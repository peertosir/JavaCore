package com.peertosir.javacore.tasks.multithread;

public class Task2Sync {
    public static void main(String[] args) {
        fizzBuzz(15);
    }

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            String result = "";
            if (i % 3 == 0) result += "fizz";
            if (i % 5 == 0) result += "buzz";
            System.out.println(result.length() > 0 ? result : i);
        }
    }
}
