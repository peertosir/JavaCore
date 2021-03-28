package com.peertosir.javacore.chapter10;

public class MultiCatch {
    public static void main(String[] args) {
        try {
            int a = args.length;
            System.out.println("a= " + a);
            int b = 42 / a;
            int[] c = {1};
            c[42] = 99;
        } catch (ArithmeticException exception) {
            System.out.println("Division by zero: " + exception);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index out of bounds: " + exception);
        }
        System.out.println("After try/catch block");
    }
}
