package Java学习.多线程.偏向锁轻量级锁重量级锁;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class 轻量级锁 {
    static Object obj = new Object();

    static int cnt = 0;

    static int n = 50000;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(轻量级锁::test);
        Thread t2 = new Thread(轻量级锁::test2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(cnt);
    }

    public static void test() {
        synchronized (obj) {
            System.out.println("test");
            for(int i = 0; i < n; i++) {
                cnt--;
            }
            test2();
        }
    }

    public static void test2() {
        synchronized (obj) {
            // 锁重入
            CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
            CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
            for(int i = 0; i < n; i++) {
                cnt++;
            }
            System.out.println("test2");
        }
    }
}
