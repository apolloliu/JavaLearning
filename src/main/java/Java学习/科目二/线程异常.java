package Java学习.科目二;

public class 线程异常 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            throw new RuntimeException();
        });
//        Thread t = new Thread(new ExceptionThread());
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("线程 " + t.getName() + " 出现异常: " + e.getMessage());
    }
}