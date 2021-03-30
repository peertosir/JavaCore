package com.peertosir.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo8 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();

        myList.add("A");
        myList.add("C");
        myList.add("F");
        myList.add("G");
        myList.add("B");

        Stream<String> myStream = myList.stream();

        Spliterator<String> spr = myStream.spliterator();

        while (spr.tryAdvance(n -> System.out.print(n + " ")));
    }
}
