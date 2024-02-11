package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Gostry M.P.
 * Замечаниее:
 * Попытался реализовать бесшовные переходы между методами, но столкнулся с проблемой в работе сканера.
 * Если его закрыть, то при повторном входе в методы (где он должен создаваться вновь) вылетало NPE.
 * Оставил вариант при котором все хотя бы работает так, как это предполагалось.
 */
public class Main {
    static Scanner scan;
    static String operation;
    static double num1;
    static double num2;
    static double result;

    // Точка входа и приветственное сообщение.
    public static void main(String[] args) {
        System.out.println("\nВас приветствует калькулятор на минималках!");
        runner();
    }

    /**
     * Основной метод данной программы, через котороый программа будет работать
     * пока пользователь не введет команду для завершение работы.
     * @see #programExit()
     */
    private static void runner() {
        scan = new Scanner(System.in);
        operationChoose();
        answerOutPut();
    }

    /**
     * Метод запришвает желаемую пользователем операцию и выполняет соответсвующий расчет.
     * Также пользователь может завершить работу программы, введя соответствующую команду
     * В случае некорректного ввода операции, начинает работу программы заново.
     *
     * @see #programExit()
     * @see #runner()
     */
    private static void operationChoose() {
        System.out.print("Выберите одну из операций ('/', '*', '+', '-') " +
                "или введите 'exit' для выхода из программы: ");
        operation = scan.next();
        switch (operation) {
            case ("+"):
                valueInput();
                result = sum();
                break;
            case ("-"):
                valueInput();
                result = subtraction();
                break;
            case ("/"):
                valueInput();
                result = division();
                break;
            case ("*"):
                valueInput();
                result = multiplication();
                break;
            case ("exit"):
                programExit();
                break;
            default:
                System.out.println("Выбрана некорректная операция, повторите ввод.");
                runner();
        }
    }

    /**
     * Метод запрашивающий числа от пользователя.
     * В случае некорректного ввода, срабатывает вспомогательный метод информирования пользователя
     * @see #helper()
     */
    private static void valueInput() {
        try {
            System.out.print("Введите первое число: ");
            num1 = scan.nextDouble();
            System.out.print("Введите первое число: ");
            num2 = scan.nextDouble();
        } catch (InputMismatchException e) {
            helper();
        }
    }

    /**
     * Метод вычисления суммы чисел
     * @return возвращает значение суммы чисел
     */
    private static double sum() {
        return num1 + num2;
    }

    /**
     * Метод вычисления разницы чисел
     * @return возвращает значение разницы чисел
     */
    private static double subtraction() {
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
        if (num2 == 0) {
            System.out.println("Указанный делитель равен нулю, операция невозможна.");
            runner();
        }
        return num1 / num2;
    }

    /**
     * Метод нахождения произведения чисел
     * @return возвращает значение произведения чисел
     */
    private static double multiplication() {
        return num1 * num2;
    }

    /**
     * Метод выводящий результат в консоль и стартующий работу программы по новой
     * @see #runner()
     */
    private static void answerOutPut() {
        System.out.printf("Результат выполнения операции = %.4f\n", result);
        runner();
    }

    /**
     * Метод вызываемый в случае некорректного ввода числового значения.
     * @see #valueInput()
     */
    private static void helper() {
        System.out.println("Вы ввели неверное значение. Допустим ввод только целых и дробных чисел.\n" +
                "Пример допустимого значения: '-123,421'.");
        runner();
    }

    // Метод выхода из калькулятора
    private static void programExit() {
        System.out.println("Завершение работы калькулятора...");
        scan.close();
        System.exit(0);
    }
}