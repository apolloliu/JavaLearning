package 设计模式.单例模式;

public class 懒汉式优化 {
    private static 懒汉式优化 instance;

    private static final Object lock = new Object();

    public static 懒汉式优化 getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    instance = new 懒汉式优化();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(懒汉式优化.getInstance().hashCode());
            }).start();
        }
    }
}
