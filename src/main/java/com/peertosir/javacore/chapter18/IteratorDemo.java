package com.peertosir.javacore.chapter18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();

        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        System.out.println("Initial state of al: " + al);

        ListIterator<String> iterator = al.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        System.out.println();

    }
}
