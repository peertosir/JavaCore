package com.peertosir.javacore.chapter11;

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread2("One");
        new NewThread2("Two");
        new NewThread2("Three");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException exception) {
            System.out.println("Main thread was interrupted");
        }
        System.out.println("Main thread finished");
    }
}

class NewThread2 implements Runnable{

    private Thread thread;

    public NewThread2(String threadName) {
        thread = new Thread(this, threadName);
        System.out.println("New thread: " + threadName);
        thread.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Thread + " + thread.getName() + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Thread + " + thread.getName() + " interrupted");
        }
        System.out.println("Thread + " + thread.getName() + " finished");
    }
}