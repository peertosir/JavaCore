package com.peertosir.javacore.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRRead {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input symbols, 'q' - to exit.");
        do {
            c = (char) br.read();
            System.out.print(c);
        } while (c != 'q');
    }
}
