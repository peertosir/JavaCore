package com.peertosir.javacore.chapter10;

public class ExcBadIdea {
    public static void main(String[] args) {
        int a = 0;
        int d;
        try {
            d = 32 / a;
        } catch (Exception ex) {
            System.out.println("Base exception");
        } //catch (ArithmeticException ex) {
//            System.out.println("Division by zero");
//        }
        System.out.println("Bad idea to put base class exceptions before child exceptions");
    }
}
