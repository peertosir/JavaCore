package com.peertosir.javacore.chapter15;

public class LambdaDemo2 {
    public static void main(String[] args) {
        MyNumeric myNumeric = n -> (n % 2) == 0;

        if (myNumeric.test(10)) System.out.println("10 is even");
        if (myNumeric.test(9)) System.out.println("9 is odd");

        MyNumeric isNonNeg = n -> n >= 0;
        if (isNonNeg.test(2)) System.out.println("2 is not negative");
        if (isNonNeg.test(-2)) System.out.println("-2 is negative");
    }
}

interface MyNumeric {
    boolean test(int n);
}


