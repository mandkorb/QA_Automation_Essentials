package com.basics.demo.calculator;

public class Calculator {
    private Double operand1;
    private Double operand2;
    private Double result;
    private Operations operation;

    public Calculator setFirstOperand(Double value) {
        operand1 = value;
        return this;
    }

    public Calculator setSecondOperand(Double value) {
        operand2 = value;
        return this;
    }

    private Calculator setOperation(Operations operation) {
        this.operation = operation;
        return this;
    }

    public Calculator plus(){
        return setOperation(Operations.PLUS);
    }

    public Calculator minus(){
        return setOperation(Operations.MINUS);
    }

    public Calculator multiply(){
        return setOperation(Operations.MULTIPLY);
    }

    public Calculator divide(){
        return setOperation(Operations.DIVIDE);
    }

    public Calculator equal(){
        calculate();
        return this;
    }

    public Double getResult() {
        return result;
    }

    public void clear(){
        operand1 = 0.0;
        operand2 = 0.0;
        operation = Operations.NA;
        result = 0.0;
    }

    private void calculate() {
        switch (operation) {
            case PLUS: {
                result = operand1 + operand2;
                break;
            }
            case MINUS: {
                result = operand1 - operand2;
                break;
            }
            case MULTIPLY: {
                result = operand1 * operand2;
                break;
            }
            case DIVIDE:{
                if (operand2 == 0){
                    System.out.println("You cannot divide by 0.");
                    result = null;
                    break;
                } else {
                    result = operand1 / operand2;
                    break;
                }
            }
            case NA: {
                System.out.println("Inappropriate operation.");
                break;
            }
        }
    }


}
