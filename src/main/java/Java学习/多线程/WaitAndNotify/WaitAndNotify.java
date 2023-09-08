package Java学习.多线程.WaitAndNotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class WaitAndNotify {
    public static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (lock) {
                log.debug("t1 start");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("t1 end");
            }
            log.debug("t1 thread end");
        }, "t1").start();


        new Thread(() -> {
            synchronized (lock) {
                log.debug("t1 start");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("t1 end");
            }
            log.debug("t2 thread end");
        }, "t2").start();

        TimeUnit.SECONDS.sleep(2);
        log.debug("开始唤醒");
        synchronized (lock) {
            log.debug("main start");
//            lock.notifyAll();
            lock.notify();
            log.debug("main end");
        }
    }
}
