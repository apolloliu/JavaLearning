package Java学习.多线程;

public class 同步关键字 {
    static int cnt = 0;

    private static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        int n = 50000;
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < n; i++) {
                        cnt--;
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < n; i++) {
                        cnt++;
                    }
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(cnt);
    }
}
