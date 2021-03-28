package com.peertosir.javacore.chapter10;

public class MultiCatchDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int[] vals = {1, 2, 3};

        try {
            int result = a / b;
//            vals[10] = 19;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
        System.out.println("After multicatch");
    }
}
