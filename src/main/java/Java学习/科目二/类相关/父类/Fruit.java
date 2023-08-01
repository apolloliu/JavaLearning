package Java学习.科目二.类相关.父类;

public class Fruit {
    public int a = 0;
    protected int b = 1;
    int c = 2;
    private int d = 3;

    void show() {
        System.out.println("Fruit Bean");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
}

class Orange {
    void show() {
        Fruit fruit = new Fruit();
        System.out.println("Orange Bean");
        System.out.println("a = " + fruit.a);
        System.out.println("b = " + fruit.b);
        System.out.println("c = " + fruit.c);
//         System.out.println("d = " + fruit.d);
    }
}
