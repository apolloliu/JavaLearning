package Java学习;

import java.util.*;

public class MainTest {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        A ab = new B();
        if (a instanceof B) {
            System.out.println("a instanceof B");
        }
        if (b instanceof B) {
            System.out.println("b instanceof B");
        }
        if (b instanceof A) {
            System.out.println("b instanceof A");
        }
        if (a instanceof A) {
            System.out.println("a instanceof A");
        }
        if (a.getClass() == B.class) {
            System.out.println("a.getClass() == B.class");
        }
//        if (b.getClass() == A.class) {
//            System.out.println("b.getClass() == A.class");
//        }
        if (b.getClass().equals(A.class)) {
            System.out.println("b.getClass().equals(A.class)");
        }
        if (ab.getClass() == A.class) {
            System.out.println("ab.getClass() == A.class");
        }
        if (ab.getClass() == B.class) {
            System.out.println("ab.getClass() == B.class");
        }
//        if (a.getClass() == A.class) {
//            System.out.println("b.getClass() == A.class");
//        }
    }
}

class A {
}

class B extends A {

}
