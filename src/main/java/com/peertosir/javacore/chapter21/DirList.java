package com.peertosir.javacore.chapter21;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {
    public static void main(String[] args) {
        String dirName = "C:\\texts";

        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirName))) {
            System.out.println("Directory: " + dirName);

            for (Path entry :
                    dirstrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);
                if (attribs.isDirectory()) {
                    System.out.print("<DIR>");
                } else {
                    System.out.print("     ");
                }
                System.out.println(entry.getName(1));
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
