package Java学习.科目二.异常继承;

import jdk.jfr.StackTrace;

public class 异常继承测试 {
    public static void main(String[] args) {
        test();
    }

    void test1() {
        try {
            throw new ExceptionB();
        } catch (Throwable e) {
            System.out.println("ExceptionA");
        }
//        } catch (Exception e) {
//            System.out.println("Exception");
//        }
    }

    static void test() {
        for(int i = 0; i < 10; i++) {
            try {
                throw new ExceptionB();
            } catch (Exception e) {
                throw new RuntimeException("hahh");
            } finally {
                System.out.println("finally " + i);
                continue;
            }
        }
    }

    // 测试父类和子类的异常并列
    void test3() {
//        try {
//            throw new ExceptionB();
//        } catch (ExceptionA | Exception e) {
//            System.out.println("Exception");
//        }
    }
}

class ExceptionA extends Exception {
}

class ExceptionB extends ExceptionA {
}
