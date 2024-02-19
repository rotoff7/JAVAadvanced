package org.example.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    private static CalculatorOOP calc;
    private static Scanner scan;
    private static final String[] validOperations = {"/", "*", "+", "-"};
    private static String userOperation;
    private static double num1;
    private static double num2;
    private static double result;
    static void calculatorRunner() {
        calc = new CalculatorOOP();
        scan = new Scanner(System.in);
        operationInput();
        valueInput();
        calculate(userOperation);
        answerOutPut();
    }
    private static void operationInput() {
        System.out.print("Выберите одну из операций ('/', '*', '+', '-') " +
                "или введите 'exit' для выхода из программы: ");
        userOperation = scan.next();
        if (userOperation.equals("exit")){
            programExit();
        }
        for (String operation: validOperations) {
            if (operation.equals(userOperation)){
                return;
            }
        }
        System.out.println("Выбрана некорректная операция, повторите ввод.");
        calculatorRunner();
    }

    private static void calculate(String sign){
        switch (sign) {
            case ("+"):
                result = calc.sum(num1, num2);
                break;
            case ("-"):
                result = calc.subtraction(num1, num2);
                break;
            case ("/"):
                try {
                    result = calc.division(num1, num2);
                } catch (ArithmeticException e){
                    System.out.println("Указанный делитель равен нулю, операция невозможна.");
                    calculatorRunner();
                }
                break;
            case ("*"):
                result = calc.multiplication(num1, num2);
                break;
            case ("exit"):
                programExit();
                break;
        }
    }
    private static void valueInput() {
        try {
            System.out.print("Введите первое число: ");
            num1 = scan.nextDouble();
            System.out.print("Введите второе число: ");
            num2 = scan.nextDouble();
        } catch (InputMismatchException e) {
            calculatorHelp();
        }
    }
    private static void answerOutPut() {
        System.out.printf("Результат выполнения операции = %.4f\n", result);
        calculatorRunner();
    }
    private static void calculatorHelp() {
        System.out.println("Вы ввели неверное значение. Допустим ввод только целых и дробных чисел.\n" +
                "Пример допустимого значения: '-123,421'.");
        calculatorRunner();
    }

    // Метод выхода из калькулятора
    private static void programExit() {
        System.out.println("Кол-во выполненных операций: " + CalculatorOOP.getOperationsCount());
        System.out.println("Завершение работы калькулятора...");
        scan.close();
        System.exit(0);
    }
}
