package com.peertosir.javacore.chapter20;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterDemo {
    public static void main(String[] args) {
        String source = "Some string to write\n to wonderful file";
        char[] buf = new char[source.length()];
        source.getChars(0, source.length(), buf, 0);

        try (FileWriter fw = new FileWriter("C:\\texts\\filewriter.txt")) {
            fw.write(buf);
        } catch (IOException ex) {
            System.out.println("IO error");
        }

        try (FileReader fr = new FileReader("C:\\texts\\filewriter.txt")){
            char[] chars = new char[source.length()];
            fr.read(chars);
            String source2 = new String(chars);
            if (source2.equals(source)) {
                System.out.println("Strings are equal");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
