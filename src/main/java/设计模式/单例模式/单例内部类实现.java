package 设计模式.单例模式;

public class 单例内部类实现 {
    private static 单例内部类实现 instance;

    private 单例内部类实现() {}

    private static class Inner {
        private static final 单例内部类实现 instance = new 单例内部类实现();
    }

    private static 单例内部类实现 getInstance() {
        return Inner.instance;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(单例内部类实现.getInstance().hashCode());
            }).start();
        }
    }
}
