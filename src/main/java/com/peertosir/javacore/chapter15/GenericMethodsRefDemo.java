package com.peertosir.javacore.chapter15;

interface NotMyFunc<T> {
    int func(T[] vals, T v);
}

class MyArrayOps {
    static <V> int countMatching(V[] vals, V v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == v) {
                count++;
            }
        }
        return count;
    }
}

public class GenericMethodsRefDemo {

    static <T> int myOp(NotMyFunc<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] strs = {"One", "Two", "Three", "Four", "Five"};

        int count;

        System.out.println("vals contains " + myOp(MyArrayOps::countMatching, vals, 4) + " times number 4");
    }
}
