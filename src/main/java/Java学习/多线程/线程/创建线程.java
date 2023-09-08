package Java学习.多线程.线程;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class 创建线程 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 继承Thread类
        Thread t1 = new MyThread("t1");
        t1.start();
        // 2. 实现Runnable接口
        Thread t2 = new Thread(new MyRunnable(), "t2");
        t2.start();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 3. 实现Callable接口
        FutureTask<Integer> t3 = new FutureTask<>(new MyCallable());
        new Thread(t3, "t3 ").start();
        log.info("t3 cost: {}", t3.get());
        stopWatch.stop();
        log.info("cost: {}ms", stopWatch.getTotalTimeMillis());
//        System.out.println(t3.get());
        // 4. 使用线程池
    }

    static class MyThread extends Thread {
        public MyThread(String t1) {
            super(t1);
        }

        @Override
        public void run() {
            log.info("MyThread");
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log.info("MyRunnable");
        }
    }

    static class MyCallable implements Runnable, Callable<Integer> {
        @Override
        public void run() {
            log.info("MyCallable");
        }

        @Override
        public Integer call() throws InterruptedException {
            log.info("MyCallable call");
            Thread.sleep(3000L);
            return 1;
        }
    }
}
