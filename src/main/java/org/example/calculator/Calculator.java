package org.example.calculator;


public final class Calculator {

    private static int operationCount = 0;
    private double number1;
    private double number2;

    public Calculator() {
    }

    public Calculator(double n1, double n2) {
        this.number1 = n1;
        this.number2 = n2;
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

    public int getOperationCount(){
        return operationCount;
    }

    public double sum() {
        operationCount += 1;
        return number1 + number2;
    }

    public double sum(double num1, double num2) {
        operationCount += 1;
        return number1 + number2;
    }

    public double subtraction() {
        operationCount += 1;
        return number1 - number2;
    }

    public double subtraction(double num1, double num2) {
        operationCount += 1;
        return number1 - number2;
    }

    public double division() throws ArithmeticException {
        if (number2 == 0){
            throw new ArithmeticException();
        }
        operationCount += 1;
        return number1 / number2;
    }

    public double division(double num1, double num2) throws ArithmeticException {
        if (num2 == 0){
            throw new ArithmeticException();
        }
        operationCount += 1;
        return number1 / number2;
    }

    public double multiplication() {
        operationCount += 1;
        return number1 * number2;
    }

    public double multiplication(double num1, double num2) {
        operationCount += 1;
        return number1 * number2;
    }

}