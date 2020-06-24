package com.xue.foundation.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Producer implements Runnable {

    private BlockingQueue queue;

    CountDownLatch downLatch = new CountDownLatch(2);
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {

                System.out.println("a");
                queue.put("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
