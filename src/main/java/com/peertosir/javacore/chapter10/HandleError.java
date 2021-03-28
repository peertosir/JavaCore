package com.peertosir.javacore.chapter10;

import java.util.Random;

public class HandleError {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        Random random = new Random();

        for (int i = 0; i < 32000; i++) {
            try {
                b = random.nextInt();
                c = random.nextInt();
                a = 12345 / (b/c);
            } catch (ArithmeticException ex) {
//                System.out.println("Division by zero!");
                System.out.println(ex);
                a = 0;
            }
            System.out.println("a: " + 0);
        }

    }
}
