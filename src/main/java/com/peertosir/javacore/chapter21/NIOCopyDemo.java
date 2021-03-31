package com.peertosir.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;

public class NIOCopyDemo {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("From and Where to COPY");
            return;
        }

        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);

            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
