package com.basics.demo.calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Double result = calculator
                .setFirstOperand(4.0)
                .divide()
                .setSecondOperand(2.0)
                .equal()
                .getResult();

        System.out.println(result);

        calculator.clear();
    }
}
