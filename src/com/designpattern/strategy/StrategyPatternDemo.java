package com.designpattern.strategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new StrategyA());
        System.out.println("Salary after strategy A: " + context.executeCalculation(10000));
        Context context2 = new Context(new StrategyB());
        System.out.println("Salary after strategy B: " + context2.executeCalculation(10000));
        Context context3 = new Context(new StrategyC());
        System.out.println("Salary after strategy C: " + context3.executeCalculation(10000));
    }
}  // End of StrategyPatternDemo.java
