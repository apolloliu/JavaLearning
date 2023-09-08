package Java学习.多线程.线程;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class park和interrupt测试 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("start...");
            LockSupport.park();
            log.info("interrupt tag={}", Thread.interrupted());
            // 会清除中断标记，所以这里是false
            LockSupport.park();
            log.debug("end...");
        });

        t1.start();
        t1.interrupt();
    }
}
