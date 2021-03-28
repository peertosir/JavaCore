package com.peertosir.javacore.chapter15;

interface NumericTest2 {
    boolean test2(int n, int d);
}

public class LambdaDemo3 {
    public static void main(String[] args) {
        NumericTest2 isFactor = (n, d) -> (n % d) == 0;
        if (isFactor.test2(4, 2)) System.out.println("2 is factor of 4");
        if (!isFactor.test2(7, 3)) System.out.println("3 is not a factor of 7");
    }
}
