package Java学习.多线程.线程;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class join测试 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("t1") {
            int count = 0;
            @Override
            public void run() {
                for(;;) {
                    log.info("------t1 count: {}", count++);
                }
            }
        };

        Thread t2 = new Thread("t2") {
            int count = 0;
            @Override
            public void run() {
                for(;;) {
                    Thread.yield();
                    log.info("             ------t2 count: {}", count++);
                }
            }
        };

        t1.start();
        t2.start();
        t1.join(5000L);
        t2.join(5000L);

    }
}
