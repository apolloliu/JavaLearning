package com.designpattern.strategy;

public class StrategyB implements Strategy {
    @Override
    public int calculate(int salary) {
        return salary * 3;
    }
}
