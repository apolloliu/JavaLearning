package Java学习;

public class 多态与继承 {
    public static void main(String[] args) {
        Base b = new Animal();
        b.eat();
//        b.run();
    }
}

class Base {
    public void eat() {
        System.out.println("Base eat");
    }

    public void sleep() {
        System.out.println("Base sleep");
    }
}

class Animal extends Base {
    public void eat() {
        System.out.println("Animal eat");
    }

    public void sleep() {
        System.out.println("Animal sleep");
    }

    public void run() {
        System.out.println("Animal run");
    }
}