package com.peertosir.javacore.tasks.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Task1 {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Runnable printFirst = () -> System.out.println("first");
        Runnable printSecond = () -> System.out.println("second");
        Runnable printThird = () -> System.out.println("third");

        Thread t1 = new Thread(() -> foo.first(printFirst));


        Thread t3 = new Thread(() -> foo.third(printThird));
        Thread t2 = new Thread(() -> foo.second(printSecond));

        try {
            Thread.sleep(1000);
            t2.start();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        t1.start();

        t3.start();


    }
}

class Foo {

    private final Semaphore semFirst;
    private final Semaphore semSecond;
    private final Semaphore semThird;

    public Foo() {
        semFirst = new Semaphore(1);
        semSecond = new Semaphore(0);
        semThird = new Semaphore(0);
    }

    public void first(Runnable r) {
        try {
            semFirst.acquire();
            r.run();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        semSecond.release();
    }
    public void second(Runnable r) {
        try {
            semSecond.acquire();
            r.run();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        semThird.release();
    }
    public void third(Runnable r) {
        try {
            semThird.acquire();
            r.run();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        semFirst.release();
    }
}