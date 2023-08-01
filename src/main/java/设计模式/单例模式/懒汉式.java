package 设计模式.单例模式;

public class 懒汉式 {
    private static 懒汉式 instance;

    private 懒汉式() {}

    public static 懒汉式 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            instance = new 懒汉式();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(懒汉式.getInstance().hashCode());
            }).start();
        }
    }
}
