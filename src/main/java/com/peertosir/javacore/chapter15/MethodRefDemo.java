package com.peertosir.javacore.chapter15;

interface StringFunc3 {
    String func(String s);
}

class MyStringOps {
    static String strReverse(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0 ; i--) {
            result += s.charAt(i);
        }
        return result;
    }
}

public class MethodRefDemo {

    static String stringOp(StringFunc3 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Some string to test";
        String outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println(inStr);
        System.out.println(outStr);
    }
}
