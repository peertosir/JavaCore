package com.peertosir.javacore.chapter15;

interface MyFunc {
    int func(int n);
}

public class ClosuresDemo {
    public static void main(String[] args) {
        int num = 10;
        MyFunc myLambda = n -> {
            //            num++; - this is not legal, variables from outer scope are readonly
            return num + n;
        };

//        num++; - this is incorrect too, num is actually final or final(caus it local scope variable)

    }
}
