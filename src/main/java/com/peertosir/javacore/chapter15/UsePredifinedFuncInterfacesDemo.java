package com.peertosir.javacore.chapter15;

import java.util.function.Function;

public class UsePredifinedFuncInterfacesDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> factorial = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
            return result;
        };

        System.out.println("Factorial of 3 is: " + factorial.apply(3));
    }
}
