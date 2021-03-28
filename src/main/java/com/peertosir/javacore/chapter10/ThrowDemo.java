package com.peertosir.javacore.chapter10;

public class ThrowDemo {
    public static void main(String[] args) {
        try {
            demoProc();
        } catch (NullPointerException ex) {
            System.out.println("Catch NPE one more time");
        }
    }

    static void demoProc() {
        try {
            throw new NullPointerException("Demo");
        } catch (NullPointerException ex) {
            System.out.println("NPE catched");
            throw ex;
        }
    }
}
