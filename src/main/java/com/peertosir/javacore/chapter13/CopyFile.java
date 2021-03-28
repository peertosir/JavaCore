package com.peertosir.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        if (args.length != 2) {
            System.out.println("Incorrect amount of arguements. Expected: 2, Actual: " + args.length);
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);

            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Input/Output error: " + e);
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException exception) {
                System.out.println("IO error during file closing");
            }
            try {
                if (fout != null) fout.close();
            } catch (IOException ioException) {
                System.out.println("IO error during file closing");
            }
        }
    }
}
