package Java学习.科目二.编程实践;

public class 运算符和表达式 {
    public static void main(String[] args) {
        char c = 'A';
        int foo = 1;
        boolean flag = true;
        System.out.println(flag ? c : foo);
        System.out.println(flag ? c : 0);
        System.out.println(flag ? c : (byte) 1);
        System.out.println(flag ? c : (short) 1);
        System.out.println(flag ? c : (int) 1);
        System.out.println(flag ? c : (long) 1);
        System.out.println(flag ? c : (float) 1);
        System.out.println(flag ? c : (double) 1);
        System.out.println(flag ? c : (char) 1);
    }
}
