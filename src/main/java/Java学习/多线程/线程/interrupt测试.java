package Java学习.多线程.线程;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

@Slf4j
public class interrupt测试 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                log.debug("t1 running...");
                if (Thread.currentThread().isInterrupted()) {
                    log.debug("t1 is interrupted");
                    break;
                }
            }
        });
        StopWatch sw = new StopWatch();
        sw.start();
        t1.start();
        log.debug("t1 start...");
        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
        sw.stop();
        log.debug("t1 interrupt, cost={}.", sw.getTotalTimeMillis());
    }
}
