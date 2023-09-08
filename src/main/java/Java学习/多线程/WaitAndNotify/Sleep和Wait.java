package Java学习.多线程.WaitAndNotify;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

@Slf4j
public class Sleep和Wait {
    static final Object room = new Object();

    static Boolean hasCigarette = false;

    static Boolean hasTakeout = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (room) {
                log.debug("有烟没？[{}]", hasCigarette);
                if (!hasCigarette) {
                    log.debug("没烟，先歇会！");
//                    try {
//                        sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
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

        for (int i = 0; i < 5; ++i) {
            new Thread(() -> {
                synchronized (room) {
                   log.debug("开始干活了！");
                }
            }, "其他人").start();
        }

        sleep(1000);
        {
            synchronized (room) {
                hasCigarette = true; //
                log.debug("烟到了噢！");
                room.notify();
//                room.notifyAll();
            }
        }
    }
}
