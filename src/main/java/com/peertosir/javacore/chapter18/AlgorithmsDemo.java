package com.peertosir.javacore.chapter18;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AlgorithmsDemo {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(-8);
        ll.add(20);
        ll.add(-20);
        ll.add(8);

        Comparator<Integer> r = Collections.reverseOrder();

        ll.sort(r);

        System.out.println("Sorted LL reversed: ");
        for (var i :
                ll) {
            System.out.print(i + " -> ");
        }
        System.out.println();
        Collections.shuffle(ll);

        System.out.println("Shuffled LL: ");
        for (var el :
                ll) {
            System.out.print(el + " -> ");
        }

        System.out.println();
        System.out.println("Max: " + Collections.max(ll));
        System.out.println("Min: " + Collections.min(ll));

    }
}
