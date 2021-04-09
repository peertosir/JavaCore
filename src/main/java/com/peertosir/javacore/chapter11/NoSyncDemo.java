package com.peertosir.javacore.chapter11;

public class NoSyncDemo {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller cl1 = new Caller("Greeting!", target);
        Caller cl2 = new Caller("In Sync", target);
        Caller cl3 = new Caller("World!", target);

        try {
            cl1.t.join();
            cl2.t.join();
            cl3.t.join();
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
    }
}

class Callme {
    synchronized void call(String message) {
        System.out.print("[" + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {

    String msg;
    Callme target;
    Thread t;

    public Caller(String msg, Callme target) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        target.call(msg);
    }
}
