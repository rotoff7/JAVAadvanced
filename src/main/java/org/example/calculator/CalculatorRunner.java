package org.example.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorRunner {
    private static Scanner scan;
    private static final Calculator calculator = new Calculator();
    private static final String[] validOperations = {"/", "*", "+", "-"};
    private static double result;

    public static void runTime() {
        scan = new Scanner(System.in);
        System.out.println("\nВам необходимо выпонлить вычисление? (yes/no)");
        String decision = scan.next();
        if (decision.equalsIgnoreCase("yes")) {
            valueInput();
        } else if (decision.equalsIgnoreCase("no")) {
            programExit();
        } else {
            System.out.println("Введенна некорректная команда. Доступные команды: yes/no");
            runTime();
        }
    }

    public static void valueInput() {
        try {
            System.out.print("Введите первое число: ");
            calculator.setNumber1(scan.nextDouble());
            System.out.print("Введите второе число: ");
            calculator.setNumber2(scan.nextDouble());
        } catch (InputMismatchException e) {
            calculatorHelp();
        }
        operationInput();
    }

    private static void operationInput() {
        System.out.print("Выберите операцию ('/', '*', '+', '-'): ");
        String userOperation = scan.next();
        for (String sign : validOperations) {
            if (sign.equals(userOperation)) {
                calculate(userOperation);
            }
        }
        System.out.println("Выбрана некорректная операция, повторите ввод.");
        operationInput();
    }

    private static void calculate(String operation) {
        switch (operation) {
            case ("+"):
                result = calculator.sum();
                break;
            case ("-"):
                result = calculator.subtraction();
                break;
            case ("/"):
                try {
                    result = calculator.division();
                } catch (ArithmeticException e) {
                    System.out.println("Указанный делитель равен нулю, операция невозможна.");
                    runTime();
                }
                break;
            case ("*"):
                result = calculator.multiplication();
                break;
        }
        answerOutPut();
        afterCalculation();
    }

    private static void afterCalculation() {
        System.out.print("Изменить операцию по введенным значениям?\n" +
                "yes - меняем операцию\n" +
                "no - выход\n" +
                "Введите команду: ");
        String afterCalculate = scan.next();
        if (afterCalculate.equalsIgnoreCase("yes")) {
            operationInput();
        } else if (afterCalculate.equalsIgnoreCase("no")) {
            runTime();
        } else {
            System.out.println("Введенна некорректная команда, повторите ввод");
            afterCalculation();
        }
    }

    public static void answerOutPut() {
        System.out.printf("\nРезультат выполнения операции = %.4f\n", result);
    }

    public static void calculatorHelp() {
        System.out.println("Вы ввели неверное значение. Допустим ввод только целых и дробных чисел.\n" +
                "Пример допустимого значения: '-123,421'.");
        runTime();
    }

    // Метод выхода из калькулятора
    public static void programExit() {
        System.out.println("Было выполнено операций: " + calculator.getOperationCount());
        System.out.println("Завершение работы калькулятора...");
        scan.close();
        System.exit(0);
    }
}

