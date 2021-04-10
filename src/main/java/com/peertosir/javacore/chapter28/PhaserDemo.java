package com.peertosir.javacore.chapter28;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int curPhase;
        System.out.println("Running threads");
        new PhaserThread(phaser, "A");
        new PhaserThread(phaser, "B");
        new PhaserThread(phaser, "C");


        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " finished");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " finished");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " finished");

        phaser.arriveAndDeregister();

        if (phaser.isTerminated()) {
            System.out.println("Phaser finished");
        }
    }
}

class PhaserThread implements Runnable {
    Phaser phaser;
    String name;

    public PhaserThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " start first phase");
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }

        System.out.println("Thread " + name + " start second phase");
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }

        System.out.println("Thread " + name + " start third phase");

        phaser.arriveAndDeregister();
    }
}