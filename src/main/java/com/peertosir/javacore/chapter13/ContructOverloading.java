package com.peertosir.javacore.chapter13;

public class ContructOverloading {
    public static void main(String[] args) {
        SampleClass sampleClass = new SampleClass();
        int a = sampleClass.getA();
        System.out.println(a);
    }
}

class SampleClass {

    private int a;

    public int getA() {
        return a;
    }

    public SampleClass() {
        this(12);
    }

    public SampleClass(int a) {
        this.a = a;
    }
}
