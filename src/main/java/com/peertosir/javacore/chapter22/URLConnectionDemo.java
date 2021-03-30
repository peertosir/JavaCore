package com.peertosir.javacore.chapter22;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionDemo {
    public static void main(String[] args) throws Exception {
        int c;
        URL google = new URL("http://www.internic.net");
        URLConnection googleConnection = google.openConnection();

        long d = googleConnection.getDate();
        if (d == 0) {
            System.out.println("No date info");
        } else {
            System.out.println("Date: " + new Date(d));
        }

        d = googleConnection.getExpiration();
        if (d == 0) {
            System.out.println("No expiration data");
        } else {
            System.out.println("Expiration date: " + new Date(d));
        }

        long len = googleConnection.getContentLengthLong();
        if (len == -1) {
            System.out.println("Content length is not available");
        } else {
            System.out.println("Content length: " + len);
        }

        if (len > 0) {
            System.out.println("Content: ");
            InputStream in = googleConnection.getInputStream();
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } else {
            System.out.println("Content is not available");
        }

    }
}
