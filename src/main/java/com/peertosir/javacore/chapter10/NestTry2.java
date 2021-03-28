package com.peertosir.javacore.chapter10;

public class NestTry2 {
    public static void main(String[] args) {
        try {
            int a = args.length;
            int b = 42 / a;
            System.out.println("a= " + a);
            NestTry2.nestTry(a);
        } catch (ArithmeticException ex) {
            System.out.println(ex);
        }
    }

    static void nestTry(int a) {
        try {
            if (a == 1)  {
                a = a / (a-a);
            }

            if (a == 2) {
                int[] c = {1};
                c[42] = 99;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
    }
}
