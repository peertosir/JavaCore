package com.peertosir.javacore.chapter29;

import java.util.ArrayList;
import java.util.Optional;

public class StreamDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(19);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b);

        productObj.ifPresent(integer -> System.out.println("Product of myList elements is: " + integer));

        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product is: " + product);
    }
}
