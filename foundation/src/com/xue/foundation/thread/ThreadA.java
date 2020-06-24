package com.xue.foundation.thread;

import java.util.Random;

public class ThreadA implements Runnable {

    private static final ThreadLocal<Integer> local = new ThreadLocal<>();

    @Override
    public void run() {
        local.set(new Random().nextInt());
        System.out.println(local.get());
    }

    /*public synchronized void test() {
        System.out.println("A");
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        System.out.println("B");
    }*/

}
