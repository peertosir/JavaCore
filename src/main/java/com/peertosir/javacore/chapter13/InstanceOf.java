package com.peertosir.javacore.chapter13;

public class InstanceOf {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        if (a instanceof A) {
            System.out.println("a is A instance");
        }

        if (b instanceof B) {
            System.out.println("b is B instance");
        }

        if (c instanceof C) {
            System.out.println("c is C instance");
        }

        if (d instanceof D) {
            System.out.println("d is D instance");
        }

        if (a instanceof C) {
            System.out.println("a can be flowed to C");
        }

        A ob;
        System.out.println("ob is A type reference");

        ob = d;

        System.out.println("ob is referred to d");

        if (ob instanceof D) {
            System.out.println("ob is D instance");
        }

        System.out.println();

        ob = c;
        if (ob instanceof D) {
            System.out.println("ob can be cast to D");
        } else {
            System.out.println("ob cannot be cast to D");
        }

        if(ob instanceof A) {
            System.out.println("ob can be cast to A");
        }

        System.out.println();

        if(a instanceof Object) {
            System.out.println("a can be cast to Object");
        }

        if(b instanceof Object) {
            System.out.println("b can be cast to Object");
        }
        if(c instanceof Object) {
            System.out.println("c can be cast to Object");
        }
        if(d instanceof Object) {
            System.out.println("d can be cast to Object");
        }



    }
}

class A {
    int i, j;
}

class B {
    int i, j;
}

class C extends A {
    int k;
}

class D extends A {
    int k;
}


