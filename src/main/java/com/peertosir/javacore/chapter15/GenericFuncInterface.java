package com.peertosir.javacore.chapter15;

interface SomeFunc<T> {
    T func(T arg);
}

public class GenericFuncInterface {
    public static void main(String[] args) {
        SomeFunc<String> reverse = str -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0 ; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("'Result' is reversed to: " + reverse.func("Result"));


        SomeFunc<Integer> factorial = num -> {
            int result = 1;
            for (int i = 1; i <= num; i++) {
                result = i * result;
            }
            return result;
        };

        System.out.println("Factorial of 3 is: " + factorial.func(3));
    }
}
