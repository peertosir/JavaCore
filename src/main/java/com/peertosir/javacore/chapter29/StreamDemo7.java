package com.peertosir.javacore.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();

        myList.add("A");
        myList.add("C");
        myList.add("F");
        myList.add("G");
        myList.add("B");

        Stream<String> myStream = myList.stream();

        Iterator<String> itr = myStream.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
