package com.peertosir.javacore.chapter15;

interface SoMyFunc<T> {
    OMyClass<T> func(T val);
}

class OMyClass<T> {
    private T val;

    public OMyClass(T val) {
        this.val = val;
    }

    public OMyClass() {
    }

    public T getVal() {
        return val;
    }
}

public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        SoMyFunc<Integer> myClassCons = OMyClass<Integer>::new;

        OMyClass<Integer> omc = myClassCons.func(123);
        System.out.println(omc.getVal());

    }
}
