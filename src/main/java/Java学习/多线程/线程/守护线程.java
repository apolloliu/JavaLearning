package Java学习.多线程.线程;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class 守护线程 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("t1 start");
            while(true) {
                if (Thread.currentThread().isInterrupted()) {
                    log.debug("t1 is interrupted");
                    break;
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("t1 end");
        });
        t1.setDaemon(true);
        t1.start();
        log.debug("main end");
    }
}
