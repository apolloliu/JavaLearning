package Java学习.多线程.同步关键字;

public class 等价表示 {
    // test1 和 test2 是等价的
    class Test {
        public synchronized void test1() {
        }

        public void test2() {
            synchronized (this) {
            }
        }
    }

    // test1 和 test2 是等价的
    class Test1 {
        public synchronized static void test1() {
        }

        public static void test2() {
            synchronized (Test1.class) {
            }
        }
    }
}
