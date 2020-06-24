import com.xue.foundation.InterfaceAndAbstract.ClassA;
import com.xue.foundation.InterfaceAndAbstract.impl.ClassAImpl;
import com.xue.foundation.children;
import com.xue.foundation.thread.Consumer;
import com.xue.foundation.thread.Producer;
import com.xue.foundation.thread.ThreadA;
import com.xue.foundation.thread.returnValue;
import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*ClassA a = new ClassAImpl();
        a.testOne();
        a.testTwo();

        List<String> list = new ArrayList<>();

        Set set = new HashSet();
        Map map = new ConcurrentHashMap();
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(2, 0);
        AtomicInteger atomicInteger = new AtomicInteger(3);*/
        /*List<List<String>> strs = new ArrayList<>();
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("d");
        strs.add(l);
        test(strs.get(0));
        System.out.println(strs.get(1));
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        LockSupport.park(dd);*/
        /*Main a = new Main();
        a.testSynchronized();
        Thread.sleep(20000);*/
        /*ThreadA a = new ThreadA();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.test();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.test2();
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();*/
        /*ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readLock.lock();
                    System.out.println(writeLock.tryLock());
                    System.out.println("写锁");
                    System.out.println(lock.getWriteHoldCount());
                    readLock.lock();
                    System.out.println("读锁");
                    System.out.println(lock.getWriteHoldCount() + "   " + lock.getReadHoldCount());
                    writeLock.unlock();
                    System.out.println(lock.getWriteHoldCount() + "   " + lock.getReadHoldCount());
                }
            }).start();
        }*/
        /*for (int i = 0; i < 2; i++) {
            new Thread(new ThreadA()).start();
        }*/
        /*BlockingQueue queue = new ArrayBlockingQueue(3);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();*/
        /*ExecutorService service = Executors.newCachedThreadPool();
        FutureTask<String> futureTask = new FutureTask<String>(new returnValue());
        service.submit(futureTask);
        final String s = futureTask.get();
        System.out.println(s);*/
        //System.out.println(children.value);
        A a = new A();
        test01(a);
        System.out.println(a);

    }

    public static void test01(A a) {
        a = null;
    }


    public static void test(List<String> strs) {
        strs.clear();
    }

    public void testSynchronized() {
        synchronized (this) {
            System.out.println("a");
        }
    }
}

class A {

}
