package com.peertosir.javacore.chapter18;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Double> hm = new HashMap<>();

        hm.put("John", 3434.3434);
        hm.put("Tom", 123.22);
        hm.put("Jane", 123.123);

        Set<Map.Entry<String, Double>> set = hm.entrySet();

        for (var me :
                set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        System.out.println();

        double balance = hm.get("John");
        hm.put("John", balance + 1000);
        System.out.println("John's remaining balance: " + hm.get("John"));
    }
}
