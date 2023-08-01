package com.designpattern.strategy;

public class StrategyC implements Strategy {
    @Override
    public int calculate(int salary) {
        return salary * 4;
    }
}
