package com.peertosir.javacore.chapter10;

public class FinallyDemo {
    static void procOne() {
        try {
            System.out.println("In procOne()");
            throw new RuntimeException("Demo");
        } finally {
            System.out.println("Finally in procOne()");
        }
    }

    static void procTwo() {
        try {
            System.out.println("In procTwo()");
            return;
        } finally {
            System.out.println("Finally in procTwo()");
        }
    }

    static void procThree() {
        try {
            System.out.println("In procThree()");
        } finally {
            System.out.println("Finally in procThree()");
        }
    }

    public static void main(String[] args) {
        try {
            procOne();
        } catch (Exception ex) {
            System.out.println("Exception catched");
        }

        procTwo();
        procThree();
    }
}
