package com.peertosir.javacore.chapter15;

public class LambdaDemo {
    public static void main(String[] args) {
        MyNumber myNumber = () -> 123.45;
        System.out.println("Fix value returned: " + myNumber.getValue());

        myNumber = () -> Math.random() * 100;

        System.out.println("Random value: " + myNumber.getValue());
        System.out.println("One more random value: " + myNumber.getValue());
    }
}

interface MyNumber {
    double getValue();
}

