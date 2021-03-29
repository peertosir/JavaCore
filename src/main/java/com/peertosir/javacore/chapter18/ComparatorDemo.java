package com.peertosir.javacore.chapter18;

import java.util.Comparator;
import java.util.TreeSet;

class MyComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}

public class ComparatorDemo {


    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(new MyComp());
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("F");
        ts.add("E");
        ts.add("D");

        for (var str :
                ts) {
            System.out.println(str);
        }
    }
}
