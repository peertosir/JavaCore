package com.peertosir.javacore.chapter18;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.add("Z");
        ll.addLast("X");
        ll.addFirst("A");

        System.out.println("Intial state of LL: " + ll);

        ll.remove("F");
        ll.remove(2);
        System.out.println("LL after removing: " + ll);

        ll.removeFirst();
        ll.removeLast();

        System.out.println("LL after second removing: " + ll);

//        String val = ll.poll();
        String val = ll.peek();
        ll.addLast(val + " changed");
        System.out.println("LL after change: " + ll);
    }
}
