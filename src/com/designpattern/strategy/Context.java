package com.designpattern.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeCalculation(int salary) {
        return strategy.calculate(salary);
    }
}
