package MultiThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreadPrint {
    public static void main(String... args) {
    }

    static class SyncThread extends Thread {
        private final CurrentFlag times;
        private int flag;
        private int count;

        public SyncThread(String name, int flag, int count, CurrentFlag times) {
            super(name);
            this.flag = flag;
            this.count = count;
            this.times = times;
        }

        public static void main(String... args) {
            CurrentFlag times = new CurrentFlag();

            Thread A = new SyncThread("A", 0, 10, times);
            Thread B = new SyncThread("B", 1, 10, times);
            Thread C = new SyncThread("C", 2, 10, times);

            A.start();
            B.start();
            C.start();
        }

        @Override
        public void run() {
            while (count > 0) {
                synchronized (times) {
                    while (times.getTimes() % 3 != flag) {
                        try {
                            times.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(getName());
                    count--;
                    times.setTimes(times.getTimes() + 1);
                    times.notifyAll();
                }
            }
        }
    }

    static class LockThread extends Thread {
        private Lock lock;
        private Condition condition;
        private int flag;
        private int count;
        private CurrentFlag times;

        public LockThread(String name, Lock lock, Condition condition, int flag, int count, CurrentFlag times) {
            super(name);
            this.lock = lock;
            this.condition = condition;
            this.flag = flag;
            this.count = count;
            this.times = times;
        }

        public static void main(String... args) {
            Lock lock1 = new ReentrantLock();
            Condition condition = lock1.newCondition();
            CurrentFlag times = new CurrentFlag();

            Thread A = new LockThread("A", lock1, condition, 0, 10, times);
            Thread B = new LockThread("B", lock1, condition, 1, 10, times);
            Thread C = new LockThread("C", lock1, condition, 2, 10, times);

            A.start();
            B.start();
            C.start();
        }

        @Override
        public void run() {
            while (count > 0) {
                lock.lock();
                try {
                    while (times.getTimes() % 3 != flag) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(getName());
                    count--;
                    times.setTimes(times.getTimes() + 1);
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class AtomicIntegerThread extends Thread {
        private int flag;
        private int count;
        private AtomicInteger atomic;

        public AtomicIntegerThread(String name, int flag, int count, AtomicInteger atomic) {
            super(name);
            this.flag = flag;
            this.count = count;
            this.atomic = atomic;
        }

        public static void main(String... args) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Thread A = new AtomicIntegerThread("A", 0, 10, atomicInteger);
            Thread B = new AtomicIntegerThread("B", 1, 10, atomicInteger);
            Thread C = new AtomicIntegerThread("C", 2, 10, atomicInteger);

            A.start();
            B.start();
            C.start();
        }

        @Override
        public void run() {
            while (count > 0) {
                if (atomic.get() % 3 == flag) {
                    System.out.println(getName());
                    count--;
                    atomic.getAndIncrement();
                } else {
                    yield();
                }
            }
        }
    }

    static class SemaphoreThread extends Thread {
        private int count;
        private Semaphore semaphore1;
        private Semaphore semaphore2;

        public SemaphoreThread(String name, int count, Semaphore semaphore1, Semaphore semaphore2) {
            super(name);
            this.count = count;
            this.semaphore1 = semaphore1;
            this.semaphore2 = semaphore2;
        }

        public static void main(String... args) {
            Semaphore semaphoreA = new Semaphore(1);
            Semaphore semaphoreB = new Semaphore(0);
            Semaphore semaphoreC = new Semaphore(0);

            Thread A = new SemaphoreThread("A", 10, semaphoreA, semaphoreB);
            Thread B = new SemaphoreThread("B", 10, semaphoreB, semaphoreC);
            Thread C = new SemaphoreThread("C", 10, semaphoreC, semaphoreA);

            A.start();
            B.start();
            C.start();
        }

        @Override
        public void run() {
            while (count > 0) {
                try {
                    semaphore1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName());
                count--;
                semaphore2.release();
            }
        }
    }

    static class CurrentFlag {
        private int times;

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }
    }
}
