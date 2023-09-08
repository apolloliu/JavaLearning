package Java学习.多线程.偏向锁轻量级锁重量级锁;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
public class 偏向锁升级为轻量级锁 {
    public static void main(String[] args) {
        Dog1 d = new Dog1();

        new Thread(() -> {
            log.debug(ClassLayout.parseInstance(d).toPrintable());
            synchronized (d) {
                log.debug(ClassLayout.parseInstance(d).toPrintable());
            }
            log.debug(ClassLayout.parseInstance(d).toPrintable());
            // 为了不出想竞争，需要等t1线程执行完
            synchronized (偏向锁升级为轻量级锁.class) {
                偏向锁升级为轻量级锁.class.notify();
            }
        }, "t1").start();

        new Thread(() -> {
            // 为了不出想竞争，需要等t1线程执行完
            synchronized (偏向锁升级为轻量级锁.class) {
                try {
                    偏向锁升级为轻量级锁.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            log.debug(ClassLayout.parseInstance(d).toPrintable());
            synchronized (d) {
                log.debug(ClassLayout.parseInstance(d).toPrintable());
            }
            log.debug(ClassLayout.parseInstance(d).toPrintable());
        }, "t2").start();
    }
}

class Dog1 {

}
