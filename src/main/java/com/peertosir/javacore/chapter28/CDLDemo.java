package com.peertosir.javacore.chapter28;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("Start execution thread");
        new MyThread(countDownLatch);

        try {
            countDownLatch.await();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        System.out.println("Finish execution thread");
    }
}

class MyThread implements Runnable {

    CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}
