package Java学习.科目二.类相关.子类;

import Java学习.科目二.类相关.父类.Operation;

public class Eat implements Operation {
    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple.a);
//        System.out.println(apple.b);
//        System.out.println(apple.c);
//        System.out.println(apple.d);
    }

    @Override
    public void eat() {
        System.out.println("Start eating.");
        System.out.println(a);
    }
}
