package Java学习.多线程.线程;

import lombok.extern.slf4j.Slf4j;

public class TwoPhaseTermination {
    public static void main(String[] args) throws InterruptedException {
        MyMonitor monitor = new MyMonitor();
        monitor.start();
        Thread.sleep(500);
        monitor.stop();
    }
}

@Slf4j
class MyMonitor {
    private Thread monitor;

    void start() {
        monitor = new Thread(() -> {
            while(true) {
                Thread current = Thread.currentThread();
                if (current.isInterrupted()) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000L);
                    log.info("执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    current.interrupt();
                }
            }
        });
        log.info("start monitor");
        monitor.start();
    }

    void stop() {
        monitor.interrupt();
    }
}