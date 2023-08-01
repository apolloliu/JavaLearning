package 设计模式.单例模式;

public enum 单例枚举 {
    INSTANCE;
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(单例枚举.INSTANCE.hashCode());
            }).start();
        }
    }
}
