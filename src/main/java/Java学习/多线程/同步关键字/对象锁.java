package Java学习.多线程.同步关键字;

public class 对象锁 {
    public static void main(String[] args) throws InterruptedException {

        Room room = new Room();
        int n = 50000;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                room.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                room.decrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(room.getCount());
    }
}


class Room {
    private int count = 0;
    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public void decrement() {
        synchronized (this) {
            count--;
        }
    }

    public int getCount() {
        // 避免读取到中间值
        synchronized (this) {
            return count;
        }
//        return count;
    }
}
