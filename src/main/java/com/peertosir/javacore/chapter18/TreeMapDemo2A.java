package com.peertosir.javacore.chapter18;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class CompLastNames implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int i, j;
        i = o1.lastIndexOf(' ');
        j = o2.lastIndexOf(' ');
        return o1.substring(i).compareToIgnoreCase(o2.substring(j));
    }
}

class CompThenByFirstName implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}

public class TreeMapDemo2A {
    public static void main(String[] args) {
        CompLastNames compLastNames = new CompLastNames();
        Comparator<String> compLastThenFirst = compLastNames.thenComparing(new CompThenByFirstName());
        TreeMap<String, Double> tm = new TreeMap<>(compLastThenFirst);

        tm.put("John Doe", 1234.12);
        tm.put("Tom Snow", 123.12);
        tm.put("Jane Eddl", 1378.123);

        Set<Map.Entry<String, Double>> set = tm.entrySet();

        for (var elem :
                set) {
            System.out.print(elem.getKey() + ": ");
            System.out.println(elem.getValue());
        }

        System.out.println();

        tm.put("Jane Eddl", tm.get("Jane Eddl") + 2000.1);

        for (var elem :
                set) {
            System.out.print(elem.getKey() + ": ");
            System.out.println(elem.getValue());
        }

        System.out.println();

    }
}
