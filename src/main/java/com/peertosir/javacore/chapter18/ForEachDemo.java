package com.peertosir.javacore.chapter18;

import java.util.ArrayList;

public class ForEachDemo {
    public static void main(String[] args) {
        ArrayList<Integer> vals = new ArrayList<>();

        vals.add(1);
        vals.add(2);
        vals.add(3);
        vals.add(4);
        vals.add(5);

        for (var i :
                vals) {
            System.out.println(i);
        }

        int sum = 0;

        for (var val :
                vals) {
            sum += val;
        }

        System.out.println("Sum: " + sum);
    }
}
