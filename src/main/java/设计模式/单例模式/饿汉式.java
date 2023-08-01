package 设计模式.单例模式;

public class 饿汉式 {
    private static final 饿汉式 instance = new 饿汉式();

    private 饿汉式() {}

    public static 饿汉式 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(饿汉式.getInstance().hashCode());
            }).start();
        }
    }
}
