package com.interview.javabasic.thread;

public class ThreadTest {
    private static void attack() {
        System.out.println("Fight");
        System.out.println("Current Thread is : " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            public void run () {
                attack();
            };
        };
        System.out.println("current main thread is : " + Thread.currentThread().getName());
        // t.run(); // main (this will use main thread)
        t.start(); // Thread-0 (this will create new thread)
        t.join();
        // Cannot make the thread live after kill a thread (join)
        // t.start(); //Exception in the thread "main" java.lang.IlleglThreadStateException
    }

}
