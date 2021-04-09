package com.peertosir.javacore.chapter11;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Current thread: " + t);

        t.setName("MAIN THREAD");
        System.out.println("Changed name of current thread: " + t);

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Main thread interrupted");
        }
    }
}
