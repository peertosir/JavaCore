package com.peertosir.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryResCopyFile {
    public static void main(String[] args) throws IOException {
        int i;
        if (args.length != 2) {
            System.out.println("Wrong amoun of arguements. Expected: 2, Actual: " + args.length);
            return;
        }

        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fout = new FileOutputStream(args[1])){
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException ex) {
            System.out.println("IO error occured...");
        }
    }
}
