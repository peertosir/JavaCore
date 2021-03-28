package com.peertosir.javacore.chapter10;

public class ChainExcDemo {
    static void demoproc() {
        NullPointerException e = new NullPointerException("High level");

        e.initCause(new ArithmeticException("Cause"));
        throw e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException ex) {
            System.out.println("Catched: " + ex);
            System.out.println("Initial exception: " + ex.getCause());
        }
    }
}

