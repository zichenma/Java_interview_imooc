package com.interview.javabasic.thread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ExecutionException;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()) {
            System.out.println("task has not finished, please wait");
        }
        System.out.println("task reture: " + task.get());
    }
}
