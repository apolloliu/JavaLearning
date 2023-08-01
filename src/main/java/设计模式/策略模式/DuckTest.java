package 设计模式.策略模式;

public class DuckTest {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.swim();
        mallard.performQuack();
        mallard.performFly();
        mallard.setFlyBehavior(new FlyWithWings());
        mallard.performFly();
    }
}
