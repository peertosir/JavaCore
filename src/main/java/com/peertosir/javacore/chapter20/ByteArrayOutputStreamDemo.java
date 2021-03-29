package com.peertosir.javacore.chapter20;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        String s = "This data should be placed in array";
        byte[] buf = s.getBytes();

        try {
            os.write(buf);
        } catch (IOException ex) {
            System.out.println("Error during writing in buffer");
            return;
        }

        System.out.println("Buffer in char string: " + os.toString());
        System.out.println("Buffer in array: ");
        byte[] b = os.toByteArray();
        for (int i = 0; i < b.length; i++) {
            System.out.print((char) b[i]);
        }
        System.out.println();

        System.out.println("To output stream: ");

        try (FileOutputStream fs = new FileOutputStream("C:\\texts\\ByteArray.txt")){
            os.writeTo(fs);
        } catch (IOException ex) {
            System.out.println("IO exception " + ex);
            return;
        }

        System.out.println("Reseting stream");

        os.reset();

        for (int i = 0; i < 3; i++) {
            os.write('X');
        }

        System.out.println(os.toString());
    }
}
