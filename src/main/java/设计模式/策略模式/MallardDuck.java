package 设计模式.策略模式;

public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
