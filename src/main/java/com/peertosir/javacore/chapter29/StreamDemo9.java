package com.peertosir.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("A");
        myList.add("C");
        myList.add("F");
        myList.add("G");
        myList.add("B");

        Stream<String> myStream = myList.stream();

        Spliterator<String> spr1 = myStream.spliterator();
        Spliterator<String> spr2 = spr1.trySplit();
        System.out.println("SPR2");
        if (spr2 != null) {
            spr2.forEachRemaining(n -> System.out.print(n + " "));
        }

        System.out.println("\nSPR1");
        spr1.forEachRemaining(n -> System.out.print(n + " "));
    }
}
