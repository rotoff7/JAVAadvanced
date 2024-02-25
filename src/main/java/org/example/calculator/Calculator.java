package org.example.calculator;


public final class Calculator {
    private static final String[] validOperations = {"/", "*", "+", "-"};
    private double result;
    private double number1;
    private double number2;
    private String operation;

    Calculator() {
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public String getOperation() {
        return operation;
    }

    public double getResult() {
        calculate();
        return result;
    }

    public void setOperation(String operation) throws IllegalArgumentException {
        for (String sign : validOperations) {
            if (operation.equals(sign)) {
                this.operation = operation;
                break;
            }
        }
        if (this.operation == null) {
            throw new IllegalArgumentException();
        }
    }

    private void calculate() {
        switch (operation) {
            case ("+"):
                this.result = sum();
                break;
            case ("-"):
                this.result = subtraction();
                break;
            case ("/"):
                this.result = division();
                break;
            case ("*"):
                this.result = multiplication();
                break;
        }
    }

    private double sum() {
        return number1 + number2;
    }

    private double subtraction() {
        return number1 - number2;
    }

    private double division() throws ArithmeticException {
        if (number2 == 0) {
            throw new ArithmeticException();
        }
        return number1 / number2;
    }

    private double multiplication() {
        return number1 * number2;
    }

}