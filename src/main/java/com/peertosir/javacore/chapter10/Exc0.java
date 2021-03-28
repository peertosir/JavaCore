package com.peertosir.javacore.chapter10;

public class Exc0 {
    public static void main(String[] args) {
        Exc0.subroutine(); //Exception with trace to subroutine
    }

    static void subroutine() {
        int d = 0;
        int a = 10 / d;
    }
}
