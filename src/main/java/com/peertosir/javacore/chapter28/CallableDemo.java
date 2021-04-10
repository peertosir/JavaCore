package com.peertosir.javacore.chapter28;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> f1;
        Future<Double> f2;
        Future<Integer> f3;

        System.out.println("Launching");

        f1 = es.submit(new SumCallable(10));
        f2 = es.submit(new HypotCallable(3, 4));
        f3 = es.submit(new FactorialCallable(5));

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }

        es.shutdown();
        System.out.println("Finishing");
    }
}

class SumCallable implements Callable<Integer> {

    int stop;

    public SumCallable(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}


class HypotCallable implements Callable<Double> {

    double side1, side2;

    public HypotCallable(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public Double call() throws Exception {
        return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
    }
}

class FactorialCallable implements Callable<Integer> {

    int stop;

    public FactorialCallable(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 2; i <= stop; i++) {
            fact *= i;
        }
        return fact;
    }
}