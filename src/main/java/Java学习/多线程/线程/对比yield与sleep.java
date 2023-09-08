package Java学习.多线程.线程;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class 对比yield与sleep {
    public static void main(String[] args) {
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
//                    Thread.yield();
                    log.info("             ------t2 count: {}", count++);
                }
            }
        };

        t1.start();
        t2.start();
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

    }
}
