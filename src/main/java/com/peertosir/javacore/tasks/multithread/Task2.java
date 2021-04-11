package com.peertosir.javacore.tasks.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

public class Task2 {
    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz(15);
        Runnable printFizz = () -> System.out.println("fizz");
        Runnable printBuzz = () -> System.out.println("buzz");
        Runnable printFizzBuzz = () -> System.out.println("fizzbuzz");
        Thread thread1 = new Thread(() -> fb.fizz(printFizz));
        Thread thread2 = new Thread(() -> fb.buzz(printBuzz));
        Thread thread3 = new Thread(() -> fb.fizzbuzz(printFizzBuzz));
        Thread thread4 = new Thread(fb::number);


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}



class FizzBuzz {
    private volatile int n;
    private Semaphore fizzSem, buzzSem, fizzBuzzSem, numSem;
    private volatile boolean isFinished;

    public FizzBuzz(int n) {
        this.n = n;
        fizzSem = new Semaphore(0);
        buzzSem = new Semaphore(0);
        fizzBuzzSem = new Semaphore(0);
        numSem = new Semaphore(0);
        isFinished = false;
    }

    public void fizz(Runnable printFizz) {
        while (!isFinished) {
            try {
                fizzSem.acquire(1);
                printFizz.run();
                numSem.release(1);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    public void buzz(Runnable printBuzz) {
        while (!isFinished) {
            try {
                buzzSem.acquire(1);
                printBuzz.run();
                numSem.release(1);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) {
        while (!isFinished) {
            try {
                fizzBuzzSem.acquire(1);
                printFizzBuzz.run();
                numSem.release(1);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    public void number() {
        try {
            numSem.release(1);
            for (int i = 1; i <= n; i++) {
                numSem.acquire(1);
                if (i % 3 == 0) {
                    if (i % 5 == 0) {
                        fizzBuzzSem.release(1);
                    } else {
                        fizzSem.release(1);
                    }
                } else if (i % 5 == 0) {
                    buzzSem.release(1);
                } else {
                    System.out.println(i);
                    numSem.release(1);
                }
            }

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        isFinished = true;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

//        fizzSem.release(); Uncomment to stop
//        buzzSem.release(); Uncomment to stop
    }
}