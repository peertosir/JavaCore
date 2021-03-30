package com.peertosir.javacore.chapter22;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL google = new URL("http://google.com");
        System.out.println("Protocol: " + google.getProtocol());
        System.out.println("Port: " + google.getPort());
        System.out.println("Host: " + google.getHost());
        System.out.println("File: " + google.getFile());
        System.out.println("Full form: " + google.toExternalForm());
    }
}
