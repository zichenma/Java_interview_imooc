package com.interview.javabasic.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;


public class ThreadPoolDemo {
    // 优点： 可以实现多个提交callable，让线程池并发处理结果
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executor.newCachedThreadPool();
        Future<String> future = newCachedThreadPool.submit(new MyCallable());
        if (!future.isDone()) {
            System.out.println("task has not finished, please wait");
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            newCachedThreadPool.shutdown();
        }

    }
}
