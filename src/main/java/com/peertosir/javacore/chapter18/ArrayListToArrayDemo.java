package com.peertosir.javacore.chapter18;

import java.util.ArrayList;

public class ArrayListToArrayDemo {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);

        System.out.println("AL contains: " + al);

        Integer[] ia = new Integer[al.size()];
        al.toArray(ia);

        int sum = 0;
        for (var i:
             ia) {
            sum += i;
        }

        System.out.println("Sum of elements in array: " + sum);
    }
}
