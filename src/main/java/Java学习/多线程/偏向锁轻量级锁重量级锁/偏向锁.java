package Java学习.多线程.偏向锁轻量级锁重量级锁;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
 */
@Slf4j
public class 偏向锁 {
    public static void main(String[] args) throws InterruptedException {
        Dog d = new Dog();
        // 调用hashcode会禁用掉偏向锁
        d.hashCode();
        log.debug(ClassLayout.parseInstance(d).toPrintable());
        synchronized (d) {
            log.debug(ClassLayout.parseInstance(d).toPrintable());
        }
        log.debug(ClassLayout.parseInstance(d).toPrintable());
    }
}

class Dog {

}
