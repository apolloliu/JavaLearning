package Java学习.科目二;

import java.math.BigDecimal;

public class 浮点精度 {
    private static final double EPS = 1e-6;

    void test1() {
        double a = 1.03d, b = 0.42d;
        float c = 1.03f, d = 0.42f;
        BigDecimal e = new BigDecimal("1.03");
        BigDecimal f = new BigDecimal("0.42");
        System.out.println(a - b);
        System.out.println(c - d);
        System.out.println(e.subtract(f));
        System.out.println((e.subtract(f).doubleValue()) - (c - d) < EPS);
        System.out.println((a - b) - (c - d) < EPS);
    }

    static void test2() {
        int big = 1999999999;
        float one = 1.0f;
        System.out.println(big * one);
        double one2 = 1.0d;
        System.out.println((double) big * one2);
    }

    void test3() {
        double num = 0.0d;
        double res = Math.cos(1 / num);
        if (Double.isNaN(res)) {
            System.out.println("NaN");
        } else {
            System.out.println("Not NaN");
        }
    }
    public static void main(String[] args) {
        test2();
    }
}
