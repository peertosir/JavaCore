package com.peertosir.javacore.chapter29;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(19);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Initial list: " + myList);

        Stream<Integer> myStream = myList.stream();

        Optional<Integer> minVal = myStream.min(Integer::compare);
        minVal.ifPresent(integer -> System.out.println("Min value: " + integer));

        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        maxVal.ifPresent(integer -> System.out.println("Max value: " + integer));

        Stream<Integer> sortedStream = myList.stream().sorted();

        sortedStream.forEach(System.out::print);

        Stream<Integer> sortedFilteredStream = myList.stream().filter(x -> x % 2 == 1).sorted();

        sortedFilteredStream.forEach(System.out::print);

    }
}
