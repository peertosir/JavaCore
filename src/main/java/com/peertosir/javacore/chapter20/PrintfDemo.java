package com.peertosir.javacore.chapter20;

public class PrintfDemo {

    public static void main(String[] args) {
        System.out.println("Some formating");
        System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);
        System.out.println();
        System.out.printf("Float by default: %f\n", 3.13);
        System.out.printf("Comma separated float: %,f\n", 3.14);
        System.out.printf("%.2f", 3.12312412412);
    }
}
