package com.peertosir.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryResShowFile {
    public static void main(String[] args) throws IOException {
        int i;
        if (args.length != 1) {
            System.out.println("Wrong amount of args. Expected: 1, Actual: " + args.length);
            return;
        }

        try (FileInputStream fin = new FileInputStream(args[0])){
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("IO error occured");
        }
    }
}
