package com.peertosir.javacore.chapter11;

public class SuspendThroughFlagDemo {
    public static void main(String[] args) {
        OThread th1 = new OThread("one");
        OThread th2 = new OThread("two");

        try {
            Thread.sleep(1000);
            th1.mysuspend();
            System.out.println("Suspend thread one");
            Thread.sleep(1000);
            th1.myresume();
            System.out.println("Resume thread one");
            th2.mysuspend();
            System.out.println("Suspend thread two");
            Thread.sleep(1000);
            th2.myresume();
            System.out.println("Resume thread two");
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }

        try {
            th1.t.join();
            th2.t.join();
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }

        System.out.println("Main thread finished");
    }
}

class OThread implements Runnable {

    String name;
    Thread t;
    boolean suspendFlag;

    public OThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException ex) {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " finished");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}

