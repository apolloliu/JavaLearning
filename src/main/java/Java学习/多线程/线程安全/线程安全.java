package Java学习.多线程.线程安全;

import java.util.ArrayList;


public class 线程安全 {
    public static void main(String[] args) {
        int thread_number = 2;
        int loop_number = 10000;
        ThreadSafeSubClass threadSafeSubClass = new ThreadSafeSubClass();
        ThreadSafe threadSafe = new ThreadSafe();
        for (int i = 0; i < thread_number; i++) {
            new Thread(() -> {
                threadSafeSubClass.method1(loop_number);
//                threadSafe.method1(loop_number);
            }, "thread" + (i + 1)).start();
        }
    }
}
class ThreadSafe {
    public void method1(int loop_number) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < loop_number; i++) {
            method2(list);
            method3(list);
        }
    }

    public void method2(ArrayList<String> list) {
        list.add("list");
    }

    public void method3(ArrayList<String> list) {
        list.remove(0);
    }
}

class ThreadSafeSubClass extends ThreadSafe {
    @Override
    public void method3(ArrayList<String> list) {
        new Thread(() -> {
            list.remove(0);
        }).start();
    }
}