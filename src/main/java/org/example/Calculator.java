package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static Scanner scan;
    private static double num1;
    private static double num2;
    private static double result;

    /**
     * Основной метод данной программы, через который программа будет работать
     * пока пользователь не введет команду для завершение работы.
     *
     * @see #programExit()
     */
    static void calculatorRunner() {
        scan = new Scanner(System.in);
        operationChoose();
        answerOutPut();
    }

    /**
     * Метод запришвает желаемую пользователем операцию и выполняет расчет.
     * Также пользователь может завершить работу программы, введя соответствующую команду
     * В случае некорректного ввода операции, оповещает пользователя и начинает работу программы заново.
     *
     * @see #programExit()
     * @see #calculatorRunner()
     */
    private static void operationChoose() {
        System.out.print("Выберите одну из операций ('/', '*', '+', '-') " +
                "или введите 'exit' для выхода из программы: ");
        String operation = scan.next();
        switch (operation) {
            case ("+"):
                result = sum();
                break;
            case ("-"):
                result = subtraction();
                break;
            case ("/"):
                result = division();
                break;
            case ("*"):
                result = multiplication();
                break;
            case ("exit"):
                programExit();
                break;
            default:
                System.out.println("Выбрана некорректная операция, повторите ввод.");
                calculatorRunner();
        }
    }

    /**
     * Метод запрашивающий числа от пользователя.
     * В случае некорректного ввода, срабатывает вспомогательный метод информирования пользователя
     *
     * @see #calculatorHelp()
     */
    private static void valueInput() {
        try {
            System.out.print("Введите первое число: ");
            num1 = scan.nextDouble();
            System.out.print("Введите первое число: ");
            num2 = scan.nextDouble();
        } catch (InputMismatchException e) {
            calculatorHelp();
        }
    }

    /**
     * Метод вычисления суммы чисел
     *
     * @return возвращает значение суммы чисел
     */
    private static double sum() {
        valueInput();
        return num1 + num2;
    }

    /**
     * Метод вычисления разницы чисел
     *
     * @return возвращает значение разницы чисел
     */
    private static double subtraction() {
        valueInput();
        return num1 - num2;
    }

    /**
     * Метод нахождения частного чисел. Если делить будет равен нулю,
     * то программа сообщит об этом пользователю и вернется к выбору операции.
     *
     * @return возвращает значение частного чисел
     * @see #operationChoose()
     */
    private static double division() {
        valueInput();
        if (num2 == 0) {
            System.out.println("Указанный делитель равен нулю, операция невозможна.");
            calculatorRunner();
        }
        return num1 / num2;
    }

    /**
     * Метод нахождения произведения чисел
     *
     * @return возвращает значение произведения чисел
     */
    private static double multiplication() {
        valueInput();
        return num1 * num2;
    }

    /**
     * Метод выводящий результат в консоль и стартующий работу программы повторно.
     * Изначально планировалось использовать другой способ округления (DecimalFormat),
     * чтоб не отоборажать лишних нулей, но в материалах был показан именно такой способ.
     *
     * @see #calculatorRunner()
     */
    private static void answerOutPut() {
        System.out.printf("Результат выполнения операции = %.4f\n", result);
        calculatorRunner();
    }

    /**
     * Метод вызываемый при вводе некорректного числового значения.
     *
     * @see #valueInput()
     */
    private static void calculatorHelp() {
        System.out.println("Вы ввели неверное значение. Допустим ввод только целых и дробных чисел.\n" +
                "Пример допустимого значения: '-123,421'.");
        calculatorRunner();
    }

    // Метод выхода из калькулятора
    private static void programExit() {
        System.out.println("Завершение работы калькулятора...");
        scan.close();
        System.exit(0);
    }
}
