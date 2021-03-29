package com.peertosir.javacore.chapter20;

import java.io.*;

public class DataIODemo {
    public static void main(String[] args) {
        try (DataOutputStream dout = new DataOutputStream(
                new FileOutputStream("C:\\texts\\dio.txt")
        )){
            dout.writeDouble(98.6);
            dout.writeInt(213);

            dout.writeBoolean(true);

        } catch (IOException ex) {
            System.out.println("IO error");
        }

        try (DataInputStream din = new DataInputStream(
                new FileInputStream("C:\\texts\\dio.txt")
        )){
            double d = din.readDouble();
            int i = din.readInt();

            boolean b = din.readBoolean();
            System.out.println(d);
            System.out.println(i);
            System.out.println(b);
        } catch (IOException ex) {
            System.out.println("IO error");
        }
    }
}
