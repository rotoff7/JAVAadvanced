package org.example.calculator;


public final class CalculatorOperations implements MathOperations {

    public static int operationsCount = 0;

    CalculatorOperations() {
    }

    public static int getOperationsCount() {
        return operationsCount;
    }

    @Override
    public double sum(double number1, double number2) {
        operationsCount += 1;
        return number1 + number2;
    }

    @Override
    public double subtraction(double number1, double number2) {
        operationsCount += 1;
        return number1 - number2;
    }

    @Override
    public double division(double number1, double number2) throws ArithmeticException {
        if (number2 == 0) {
            throw new ArithmeticException();
        }
        operationsCount += 1;
        return number1 / number2;
    }

    @Override
    public double multiplication(double number1, double number2) {
        operationsCount += 1;
        return number1 * number2;
    }
}
