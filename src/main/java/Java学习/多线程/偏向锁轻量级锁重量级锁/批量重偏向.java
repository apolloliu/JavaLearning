package Java学习.多线程.偏向锁轻量级锁重量级锁;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class 批量重偏向 {

    public static void main(String[] args) {
        int LOOP_COUNT = 20;
        Dog d = new 批量重偏向().new Dog();
        for (int i = 0; i < LOOP_COUNT; i++) {
             new Thread(() -> {
                   synchronized (d) {
                       log.debug(ClassLayout.parseInstance(d).toPrintable());
                   }
             }, "t1").start();
            LockSupport.unpark(Thread.currentThread());
        }

        for (int i = 0; i < LOOP_COUNT; i++) {
            new Thread(() -> {
                log.debug(ClassLayout.parseInstance(d).toPrintable());
                synchronized (d) {
                    log.debug(ClassLayout.parseInstance(d).toPrintable());
                }
                log.debug(ClassLayout.parseInstance(d).toPrintable());
            }, "t2").start();
        }
    }

    class Dog {

    }
}

