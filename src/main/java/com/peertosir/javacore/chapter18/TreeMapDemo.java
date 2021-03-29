package com.peertosir.javacore.chapter18;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, Double> tm = new TreeMap<>();

        tm.put("John", 1234.12);
        tm.put("Tom", 123.12);
        tm.put("Jane", 1378.123);


        Set<Map.Entry<String, Double>> set = tm.entrySet();

        for (var me :
                set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        System.out.println();
    }
}
