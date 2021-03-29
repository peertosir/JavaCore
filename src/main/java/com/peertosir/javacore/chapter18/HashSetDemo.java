package com.peertosir.javacore.chapter18;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add("D");

        System.out.println(hs); //stored in not-sorted way
    }
}
