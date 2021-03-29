package com.peertosir.javacore.chapter20;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;

        try (FileInputStream f = new FileInputStream("C:\\Users\\peert\\IdeaProjects\\JavaCore" +
                "\\src\\main\\java\\com\\peertosir\\javacore\\chapter20\\FileInputStreamDemo.java")) {
            System.out.println("Overall bytes available: " + (size = f.available()));

            int n = size / 40;

            System.out.println("First " + n + " bytes, " + "read from with read()");
            for (int i = 0; i < n; i++) {
                System.out.print((char) f.read());
            }

            System.out.println("Still available: " + f.available());

            System.out.println("Reading next " + n + " bytes with read(byte[] t)");
            byte[] b = new byte[n];
            if (f.read(b) != n) {
                System.err.println("Cannot read " + n + " bytes");
            }

            System.out.println(new String(b, 0, n));
            System.out.println("Still available: " + (size = f.available()));

            System.out.println("Skip a half of remaining bytes...");
            f.skip(size / 2);
            System.out.println("Still available: " + f.available());
            System.out.println("Reading " + n/2 + " bytes, which are in the end of an array");
            if (f.read(b, n/2, n/2) != n/2) {
                System.err.println("Cannot read " + n/2 + " bytes");
            }

            System.out.println(new String(b, 0, b.length));
            System.out.println("Still available: " + f.available());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
