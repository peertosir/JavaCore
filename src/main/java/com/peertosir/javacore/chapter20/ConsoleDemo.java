package com.peertosir.javacore.chapter20;

import java.io.Console;

public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console console;

        console = System.console();

        if (console == null) return;

        str = console.readLine("Input a string.. ");
        console.printf("Your string is %s\n", str);
    }
}
