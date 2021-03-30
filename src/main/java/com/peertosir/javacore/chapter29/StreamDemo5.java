package com.peertosir.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(7.1);
        myList.add(18.2);
        myList.add(10.4);
        myList.add(24.7);
        myList.add(17.9);
        myList.add(5.3);

        System.out.println("Initial myList: " + myList);

        myList.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();

        IntStream cStrm = myList.stream().mapToInt(a -> (int) Math.ceil(a));

        System.out.println("max limits for values from myList: ");
        cStrm.forEach(a -> System.out.print(a + " "));

    }
}
