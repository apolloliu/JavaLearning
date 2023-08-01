package 设计模式.策略模式;

public abstract class Duck {
    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    void swim(){
        System.out.println("swim");
    }

    abstract void display();

    void performFly(){
        flyBehavior.fly();
    }

    void performQuack(){
        quackBehavior.quack();
    }

    void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }
    void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }
}
