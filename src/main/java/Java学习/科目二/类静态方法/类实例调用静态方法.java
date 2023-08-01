package Java学习.科目二.类静态方法;

class Dog {
    public static void show() {
        System.out.println("Dog show");
    }
}

class Baenji extends Dog {
    public static void show() {
        System.out.println("Baenji show");
    }
}

public class 类实例调用静态方法 {
    public static void main(String[] args) {
        Dog dog = new Baenji();
        Dog dog2 = new Dog();
        dog.show();
        dog2.show();
        Dog.show();
        Baenji.show();
    }
}
