package com.peertosir.javacore.tasks.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Task1 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Foo foo = new Foo();

        new Task1Thread(lock, foo);
        new Task1Thread(lock, foo);
        new Task1Thread(lock, foo);
    }
}

class Foo {

    public void first() {
        System.out.println("first");
    }
    public void second() {
        System.out.println("second");
    }
    public void third() {
        System.out.println("third");
    }
}

class Task1Thread implements Runnable {

    static int order = 1;
    ReentrantLock lock;
    Foo foo;

    public Task1Thread(ReentrantLock lock, Foo foo) {
        this.lock = lock;
        this.foo = foo;
        new Thread(this).start();
    }

    @Override
    public void run() {
        lock.lock();
        switch (order) {
            case 1:
                foo.first();
                break;
            case 2:
                foo.second();
                break;
            case 3:
                foo.third();
                break;
        }
        order++;
        lock.unlock();
    }
}
