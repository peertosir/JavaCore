package com.peertosir.javacore.chapter20;

import java.io.*;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        String s = "this is copyright sign &copy; " +
                ", and &copy - dont\n";

        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        int c;

        CharArrayReader car = new CharArrayReader(buf);
        boolean marked = false;

        try (BufferedReader f = new BufferedReader(car)){
            while ((c = f.read()) != -1) {
                switch (c) {
                    case '&':
                        if (!marked) {
                            f.mark(32);
                            marked = true;
                        } else {
                            marked = false;
                        }
                        break;
                    case ';':
                        if (marked) {
                            marked = false;
                            System.out.print("(c)");
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            f.reset();
                            System.out.print("&");
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    default:
                        if (!marked) {
                            System.out.print((char) c);
                        }
                        break;
                }
            }
        } catch (IOException ex) {
            System.out.println("IO error");
        }

    }
}
