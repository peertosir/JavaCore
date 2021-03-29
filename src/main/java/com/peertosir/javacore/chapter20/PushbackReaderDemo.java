package com.peertosir.javacore.chapter20;

import java.io.*;

public class PushbackReaderDemo {
    public static void main(String[] args) {
        String s = "if (a == 4) a = 0;\n";
        char[] buf = new char[s.length()];
        s.getChars(0 ,s.length(), buf, 0);
        CharArrayReader in = new CharArrayReader(buf);
        int c;

        try (PushbackReader pb = new PushbackReader(in)){
            while ((c = pb.read()) != -1) {
                if (c == '=') {
                    if ((c = pb.read()) == '=') {
                        System.out.print(".eq.");
                    } else {
                        System.out.print("<-");
                        pb.unread(c);
                    }
                } else {
                    System.out.print((char) c);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
