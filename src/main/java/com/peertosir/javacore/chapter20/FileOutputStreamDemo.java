package com.peertosir.javacore.chapter20;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n" +
                " to come to the aid of their country\n" +
                " and pay their due taxes";

        byte[] buffer = source.getBytes();

        FileOutputStream f1 = null;
        FileOutputStream f2 = null;
        FileOutputStream f3 = null;

        try {
            f1 = new FileOutputStream("C:\\texts\\file1.txt");
            f2 = new FileOutputStream("C:\\texts\\file2.txt");
            f3 = new FileOutputStream("C:\\texts\\file3.txt");

            for (int i = 0; i < buffer.length; i+= 2) {
                f1.write(buffer[i]);
            }

            f2.write(buffer);

            f3.write(buffer, buffer.length / 4, buffer.length / 4);
        } catch (IOException ex) {
            System.out.println("IO exception");
        } finally {
            try {
                if (f1 != null) {
                    f1.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                if (f2 != null) {
                    f2.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                if (f3 != null) {
                    f3.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
