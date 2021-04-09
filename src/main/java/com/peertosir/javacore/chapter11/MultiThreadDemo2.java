package com.peertosir.javacore.chapter11;

public class MultiThreadDemo2 {
    public static void main(String[] args) {
        NewThread3 t1 = new NewThread3("One");
        NewThread3 t2 = new NewThread3("Two");
        NewThread3 t3 =new NewThread3("Three");

        System.out.println("Thread " + t1.getThread().getName() + " is alive? - " + t1.getThread().isAlive());
        System.out.println("Thread " + t2.getThread().getName() + " is alive? - " + t2.getThread().isAlive());
        System.out.println("Thread " + t3.getThread().getName() + " is alive? - " + t3.getThread().isAlive());

        try {
            t1.getThread().join();
            t2.getThread().join();
            t3.getThread().join();
        } catch (InterruptedException exception) {
            System.out.println("Main thread was interrupted");
        }

        System.out.println("Thread " + t1.getThread().getName() + " is alive? - " + t1.getThread().isAlive());
        System.out.println("Thread " + t2.getThread().getName() + " is alive? - " + t2.getThread().isAlive());
        System.out.println("Thread " + t3.getThread().getName() + " is alive? - " + t3.getThread().isAlive());

        System.out.println("Main thread finished");
    }
}

class NewThread3 implements Runnable{

    private Thread thread;

    public Thread getThread() {
        return thread;
    }

    public NewThread3(String threadName) {
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