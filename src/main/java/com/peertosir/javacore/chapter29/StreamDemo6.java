package com.peertosir.javacore.chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NamePhoneMail {
    String name;
    String phone;
    String mail;

    @Override
    public String toString() {
        return "NamePhoneMail{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public NamePhoneMail(String name, String phone, String mail) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }
}

class NamePhone {
    String name;
    String phone;

    @Override
    public String toString() {
        return "NamePhone{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public NamePhone(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class StreamDemo6 {
    public static void main(String[] args) {
        ArrayList<NamePhoneMail> myList = new ArrayList<>();
        myList.add(new NamePhoneMail("Elena", "8-800-5553535", "elena@elena.el"));
        myList.add(new NamePhoneMail("Pavel", "8-800-5553536", "pavel@pavel.pv"));
        myList.add(new NamePhoneMail("Ivan", "8-800-5553537", "ivan@ivan.iv"));

        Stream<NamePhone> namePhoneStream = myList.stream().map(a -> new NamePhone(a.name, a.phone));

        List<NamePhone> npList = namePhoneStream.collect(Collectors.toList());


        System.out.println("Names and phones in List: ");
        npList.forEach(System.out::println);
        namePhoneStream = myList.stream().map(a -> new NamePhone(a.name, a.phone));

        Set<NamePhone> npSet = namePhoneStream.collect(Collectors.toSet());


        System.out.println("Names and phones in Set: ");
        npList.forEach(System.out::println);

    }
}
