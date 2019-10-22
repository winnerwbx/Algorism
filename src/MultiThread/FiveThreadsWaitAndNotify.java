package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. 启动5个线程
 * 2. 所有线程等待
 * 3. 通知线程同时恢复
 *
 * @author wangboxuan@meituan.com
 * @since 2019/10/22
 */
public class FiveThreadsWaitAndNotify {
    public static void main(String... args) {
        CountDownLatch latch = new CountDownLatch(5);
        Lock lock = new ReentrantLock();
        Condition cd = lock.newCondition();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MyThread thread = new MyThread(i, lock, cd, latch);
            threads.add(thread);
            thread.start();
        }
        try {
            latch.await();
            System.out.println("back to main thread");
            lock.lock();
            cd.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("All finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyThread extends Thread {
        private int name;
        private Lock lock;
        private Condition condition;
        private CountDownLatch latch;

        public MyThread(int name, Lock lock, Condition condition, CountDownLatch latch) {
            this.name = name;
            this.lock = lock;
            this.condition = condition;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println(name + " is running");
            try {
                lock.lock();
                latch.countDown();
                condition.await();
                System.out.println(name + " is back");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(name + " finished.");
        }
    }
}
