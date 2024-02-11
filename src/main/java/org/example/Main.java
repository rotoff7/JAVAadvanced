package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Gostry M.P.
 * Замечание:
 * Попытался реализовать бесшовные переходы между методами, но столкнулся с проблемой в работе сканера.
 * Если его закрыть, то при повторном входе в методы (где он должен создаваться вновь) вылетало NPE.
 * Оставил вариант при котором все хотя бы работает так, как это предполагалось.
 * Помимо этого многие методы в данной реализации явно избыточны, их можно было внедрить в уже существующие.
 * Более атомарные разделения совершенны для дополнительного использования Javadocs
 * и возможности внедрения дополнительной логики в будущем.
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
     * Основной метод данной программы, через который программа будет работать
     * пока пользователь не введет команду для завершение работы.
     * @see #programExit()
     */
    private static void runner() {
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
     * @see #runner()
     */
    private static void operationChoose() {
        System.out.print("Выберите одну из операций ('/', '*', '+', '-') " +
                "или введите 'exit' для выхода из программы: ");
        operation = scan.next();
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
        valueInput();
        return num1 + num2;
    }

    /**
     * Метод вычисления разницы чисел
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
            runner();
        }
        return num1 / num2;
    }

    /**
     * Метод нахождения произведения чисел
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
     * @see #runner()
     */
    private static void answerOutPut() {
        System.out.printf("Результат выполнения операции = %.4f\n", result);
        runner();
    }

    /**
     * Метод вызываемый при вводе некорректного числового значения.
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