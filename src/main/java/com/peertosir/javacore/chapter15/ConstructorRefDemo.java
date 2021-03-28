package com.peertosir.javacore.chapter15;

interface MyFuunc {
    MyClass func(int n);
}

class MyClass {
    private int val;

    public MyClass(int val) {
        this.val = val;
    }

    public MyClass() {
        this(0);
    }

    int getVal() {
        return val;
    }
}

public class ConstructorRefDemo {
    public static void main(String[] args) {
        MyFuunc myClassConstr = MyClass::new;
        MyClass mc = myClassConstr.func(2);
        System.out.println(mc.getVal());
    }
}
