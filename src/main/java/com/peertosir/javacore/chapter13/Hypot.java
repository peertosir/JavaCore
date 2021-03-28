package com.peertosir.javacore.chapter13;

import static java.lang.Math.*;

public class Hypot {
    public static void main(String[] args) {
        double side1, side2;
        double hypot;

        side1 = 0.4;
        side2 = 0.5;

        hypot = sqrt(pow(side1, 2) + pow(side2, 2));
        System.out.println("Hypot is: " + hypot);
    }
}
