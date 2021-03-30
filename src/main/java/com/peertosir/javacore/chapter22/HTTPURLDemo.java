package com.peertosir.javacore.chapter22;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HTTPURLDemo {
    public static void main(String[] args) throws Exception {
        URL hp = new URL("http://www.google.com");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        System.out.println("Request method: " + hpCon.getRequestMethod());
        System.out.println("Status Code: " + hpCon.getResponseCode());
        System.out.println("Response message: " + hpCon.getResponseMessage());

        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();
        System.out.println("Next header is: \n");
        for (String k:
             hdrField) {
            System.out.println("Header: " + k + ". Header value: " + hdrMap.get(k));
        }
    }
}
