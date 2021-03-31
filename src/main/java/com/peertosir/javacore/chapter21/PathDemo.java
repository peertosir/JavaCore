package com.peertosir.javacore.chapter21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class PathDemo {
    public static void main(String[] args) {
        Path filepath = Paths.get("C:\\texts\\TEXT.txt");

        System.out.println("File name: " + filepath.getFileName());
        System.out.println("Path to file: " + filepath);
        System.out.println("Abs. path to file: " + filepath.toAbsolutePath());

        if (Files.exists(filepath)) {
            System.out.println("File exists");
        } else {
            System.out.println("File doesn't exist");
        }

        try {
            if (Files.isHidden(filepath)) {
                System.out.println("File is hidden");
            } else {
                System.out.println("File is not hidden");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try {
            BasicFileAttributes attributes = Files.readAttributes(filepath, BasicFileAttributes.class);
            if (attributes.isDirectory()) {
                System.out.println("This is directory");
            }

            if (attributes.isRegularFile()) {
                System.out.println("This is regular file");
            }

            if (attributes.isSymbolicLink()) {
                System.out.println("This is symlink");
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
