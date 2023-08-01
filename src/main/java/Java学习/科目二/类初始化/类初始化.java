package Java学习.科目二.类初始化;

import java.math.BigDecimal;

public class 类初始化 {
    private static final double EPS = 1e-6;
    static class A {
        public static final int a = 1;
        public static final String s = "sss";
        public static int b = 2;
        static {
            System.out.println("initA");
        }
        public static void bark() {
            System.out.println("A bark");
        }
    }

    static class B extends A {
        static {
            System.out.println("initB");
        }
        public static void bark() {
            System.out.println("B bark");
        }
    }


    static void show() {
        int count = 0;
        for(int i = 0; i < 100; i++) {
            count = (count++);
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
//        System.out.println("A.a=" + A.a);
//        System.out.println("A.s=" + A.s);
//        System.out.println("B.b=" + B.b);
//        A[] as = new A[5];
//        System.out.println("B.a=" + B.a);
//        int count = 0;
//        for(int i = 0; i < 100; i++){
//            count = count++;
//        }
//        System.out.println(count);
//        A a = new A();
//        A b = new B();
//        a.bark();



//        b.bark();
//        B.bark();

        show();

    }
}
