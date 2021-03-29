package com.peertosir.javacore.chapter20;

import java.io.File;

public class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File("C:\\texts\\TEXT.txt");
        p("File name: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Abs. path: " + f1.getAbsolutePath());
        p("Parent dir.: " + f1.getParent());
        p(f1.exists() ? "exists" : "not exists");
        p(f1.canWrite() ? "ready to be written in" : "cannot be changed");
        p(f1.canRead() ? "can be read" : "cannot be read");
        p(f1.isDirectory() ? "is a dir" : "not a dir");
        p(f1.isFile()? "is a file" : "not a file");
        p(f1.isAbsolute() ? "is absolute" : "is not absolute");
        p("Size: " + f1.length() + " KB");
    }
}
