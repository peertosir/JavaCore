package com.peertosir.javacore.chapter18;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(43);
        lhs.add(32);
        lhs.add(-1);

        System.out.println(lhs); // stored in sorted way
    }
}
