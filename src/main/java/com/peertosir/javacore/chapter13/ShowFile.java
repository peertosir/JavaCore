package com.peertosir.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin;

        if (args.length != 1) {
            System.out.println("Incorrect amount of arguements. Expected: 1, Actual: " + args.length);
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot find or open a file: " + args[0]);
            return;
        }

        try {
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (IOException ex) {
            System.out.println("Error during reading the file");
        }

        try {
            fin.close();
        } catch (IOException ex) {
            System.out.println("Error during closing the file");
        }




    }
}
