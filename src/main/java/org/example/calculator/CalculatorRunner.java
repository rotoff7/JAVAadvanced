package org.example.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorRunner {
    private static Scanner scan;
    private static final Calculator calculator = new Calculator();

    public static void operationInput() {
        scan = new Scanner(System.in);
        System.out.print("Выберите одну из операций ('/', '*', '+', '-') " +
                "или введите 'exit' для выхода из программы: ");
        String userOperation = scan.next();
        if (userOperation.equals("exit")){
            programExit();
        }
        try {
            calculator.setOperation(userOperation);
        } catch (IllegalArgumentException e){
            System.out.println("Введенна некорректная операция");
            programExit();
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
    }
    public static void answerOutPut() {
        try {
            System.out.printf("Результат выполнения операции = %.4f\n", calculator.getResult());
        } catch (ArithmeticException e){
            System.out.println("Указанный делитель равен нулю, операция невозможна.");
        }
    }
    public static void calculatorHelp() {
        System.out.println("Вы ввели неверное значение. Допустим ввод только целых и дробных чисел.\n" +
                "Пример допустимого значения: '-123,421'.");
        programExit();
    }

    // Метод выхода из калькулятора
    public static void programExit() {
        System.out.println("Завершение работы калькулятора...");
        scan.close();
        System.exit(0);
    }
}

