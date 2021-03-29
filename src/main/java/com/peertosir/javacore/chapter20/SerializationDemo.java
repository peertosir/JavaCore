package com.peertosir.javacore.chapter20;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\texts\\serial.txt"))) {
            MyClass myClass = new MyClass("John", 25, 123214.1214);
            System.out.println("myClass: " + myClass);
            oos.writeObject(myClass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\texts\\serial.txt"))){
            MyClass myClass2;
            myClass2 = (MyClass) ois.readObject();
            System.out.println("myClass2: " + myClass2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class MyClass implements Serializable {
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", d=" + d +
                '}';
    }
}