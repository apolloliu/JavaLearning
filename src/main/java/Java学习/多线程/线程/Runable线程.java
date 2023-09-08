package Java学习.多线程.线程;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Runable线程 {


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.info("t1 start...");
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    log.info("t1 interrupted...");
                    e.printStackTrace();
                }
            }
        };

        log.debug("t1 state: {}", t1.getState());
        // 不是立刻执行
        t1.start();
        log.debug("t1 state: {}", t1.getState());

        TimeUnit.MILLISECONDS.sleep(500);
        // 说明不是立刻打断
        t1.interrupt();
        log.debug("t1 state: {}", t1.getState());
        t1.join();
        log.debug("t1 state: {}", t1.getState());
    }
}
