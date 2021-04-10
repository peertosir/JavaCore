package com.peertosir.javacore.chapter28;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecDemo {

    public static void main(String[] args) {
        CountDownLatch latch1 = new CountDownLatch(5);
        CountDownLatch latch2 = new CountDownLatch(5);
        CountDownLatch latch3 = new CountDownLatch(5);
        CountDownLatch latch4 = new CountDownLatch(5);

        ExecutorService es = Executors.newFixedThreadPool(2);
        System.out.println("Launching threads");

        es.execute(new ExecThreadPool("A", latch1));
        es.execute(new ExecThreadPool("B", latch2));
        es.execute(new ExecThreadPool("C", latch3));
        es.execute(new ExecThreadPool("D", latch4));

        try {
            latch1.await();
            latch2.await();
            latch3.await();
            latch4.await();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        es.shutdown();
        System.out.println("Finishing threads");
    }
}

class ExecThreadPool implements Runnable {
    String name;
    CountDownLatch latch;

    public ExecThreadPool(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
        new Thread(this);
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
