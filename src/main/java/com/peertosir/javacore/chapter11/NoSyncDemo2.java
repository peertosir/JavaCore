package com.peertosir.javacore.chapter11;

public class NoSyncDemo2 {
    public static void main(String[] args) {
        Callme2 target = new Callme2();
        Caller2 cl1 = new Caller2("Greeting!", target);
        Caller2 cl2 = new Caller2("In Sync", target);
        Caller2 cl3 = new Caller2("World!", target);

        try {
            cl1.t.join();
            cl2.t.join();
            cl3.t.join();
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
    }
}

class Callme2 {
    void call(String message) {
        System.out.print("[" + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller2 implements Runnable {

    String msg;
    final Callme2 target;
    Thread t;

    public Caller2(String msg, Callme2 target) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}
