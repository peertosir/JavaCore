package com.peertosir.javacore.chapter10;

public class ExceptionDemo {

    static void compute(int a) throws MyException {
        System.out.println("Method compute() called with: " + a);
        if (a > 10) {
            throw new MyException(a);
        }
        System.out.println("Normal exit");
    }

    public static void main(String[] args) {
        try {
            compute(1);
            compute(20);
        } catch (MyException ex) {
            System.out.println("Exception catched: " + ex);
        }
    }
}

class MyException extends Exception {
    private int detail;

    public MyException(int detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}
