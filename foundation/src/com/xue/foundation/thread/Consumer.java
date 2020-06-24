package com.xue.foundation.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Consumer implements Runnable {

    private BlockingQueue queue;

    private CountDownLatch latch = new CountDownLatch(2);

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(queue.take().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
