package com.peertosir.javacore.chapter15;

interface StringFunc2 {
    String func(String n);
}

public class LambdasAsArgsDemo {

    static String stringOp(StringFunc2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambda funcs are raising effectiveness of Java";
        String outStr;

        System.out.println("This is initial string: " + inStr);

        outStr = stringOp(x -> {
            String result = "";
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) != ' ') {
                    result += x.charAt(i);
                }
            }
            return result;
        }, "String with spaces");

        System.out.println(outStr);
    }
}
