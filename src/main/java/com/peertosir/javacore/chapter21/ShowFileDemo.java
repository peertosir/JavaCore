package com.peertosir.javacore.chapter21;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShowFileDemo {
    public static void main(String[] args) {
        int i;

        if (args.length != 1) {
            System.out.println("ShowFile <filename>");
            return;
        }

        try (InputStream fin = Files.newInputStream(Paths.get(args[0]))) {
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
