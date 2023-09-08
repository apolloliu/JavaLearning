package Java学习.多线程.WaitAndNotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Wait实践之香烟和外卖2 {

    static final Object room = new Object();

    static Boolean hasCigarette = false;

    static Boolean hasTakeout = false;

    // 虚假唤醒
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (room) {
                log.debug("有烟没？[{}]", hasCigarette);
                while (!hasCigarette) {
                    log.debug("没烟，先歇会！");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("有烟没？[{}]", hasCigarette);
                if (hasCigarette) {
                    log.debug("可以开始干活了！");
                }
            }
        }, "小南").start();

        new Thread(() -> {
            synchronized (room) {
                log.debug("有外卖没？[{}]", hasTakeout);
                if (!hasTakeout) {
                    log.debug("没外卖，先歇会！");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("有外卖没？[{}]", hasTakeout);
                if (hasTakeout) {
                    log.debug("可以开始干活了！");
                }
            }
        }, "小女").start();

        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (room) {
                hasTakeout = true;
                log.debug("外卖到了噢！");
//                room.notify();
                room.notifyAll();
            }
        }, "送外卖的").start();
    }
}
