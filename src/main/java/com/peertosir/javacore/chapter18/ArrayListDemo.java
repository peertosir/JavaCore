package com.peertosir.javacore.chapter18;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        System.out.println("Initial size of arraylist is: " + al.size());

        al.add("C");
        al.add("A");
        al.add("D");
        al.add("B");
        al.add("F");
        al.add(1, "A2");
        System.out.println("Current size of arraylist is: " + al.size());

        System.out.println("ArrayList contains: " + al);

        al.remove("F");
        al.remove(1);
        System.out.println("ArrayList after-removing size is: " + al.size());
        System.out.println("ArrayList contains: " + al);

    }
}
