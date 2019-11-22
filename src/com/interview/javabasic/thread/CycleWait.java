package com.interview.javabasic.thread;

public class CycleWait implements Runnable {
    public String value;

    public void run () {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "We have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread t1 = new Thread(cw);
        t1.start();
        while (cw.value == null) {
            // Method 1:  make main thread waiting
            // Thread.currentThread().sleep(100);
            // Pros: simple
            // Cons: 1. if there are too many variables, the logic will be complicated
            // 2. cannot accurately control waiting time (every time need to wait 100 ms)
            // Method 2: join() (block current thread waiting child thread finish)
             t1.join();
            // Pros: simple and more accurate
            // Cons: not accurate enough
            // Method 3: callable (demo in MyCallable class)
        }
        System.out.println("value : " + cw.value);
    }
}
