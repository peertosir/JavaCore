package com.peertosir.javacore.chapter15;

interface OMyIFace<R, T> {
    R func(T n);
}

class SoMyClass<T> {
    private T val;

    public SoMyClass(T val) {
        this.val = val;
    }

    public SoMyClass() {
    }

    public T getVal() {
        return val;
    }
}

class NoSoMyClass {
    private String val;

    public NoSoMyClass(String val) {
        this.val = val;
    }

    public NoSoMyClass() {
    }

    public String getVal() {
        return val;
    }
}

public class ConstructorRedDemo3 {

    static <R, T> R myClassFactory(OMyIFace<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        OMyIFace<SoMyClass<Double>, Double> myClassCons = SoMyClass<Double>::new;

        SoMyClass<Double> mc = myClassFactory(myClassCons, 100.1);

        System.out.println(mc.getVal());


    }
}
