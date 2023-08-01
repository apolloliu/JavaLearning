package com.designpattern.strategy;

public class StrategyA implements Strategy {
    @Override
    public int calculate(int salary) {
        return salary * 2;
    }
}
