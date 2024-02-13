package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Gostry M.P.
 * Сделал топорненько разделение на классы, для более простого ориентирования в этом всем деле.
 */
public class Main {
    private static short type;

    // Точка входа и приветственное сообщение.
    public static void main(String[] args) {
        programTypeChoose();
    }

    /**
     * Диалоговое окно выбора режима работы программы.
     * Использует вспомогательный метод определения режима работы через введенное значение
     * @see #programTypeSelector()
     */
    private static void programTypeChoose() {
        System.out.print("Выберите тип подпрограммы: \n1 - Запуск калькулятора. " +
                "\n2 - Максимальное слово в массиве. \nЖелаемый тип подпрограммы: ");
        Scanner scan = new Scanner(System.in);
        try {
            type = scan.nextShort();
        } catch (InputMismatchException e) {
            System.out.println("Введено некорректное значение.");
            programTypeChoose();
        }
        programTypeSelector();
    }

    // Вспомогательный метод определения режима работы программы через введенное значение
    private static void programTypeSelector() {
        if (type == 1) {
            System.out.println("\nВас приветствует калькулятор на минималках!");
            Calculator.calculatorRunner();
        } else if (type == 2) {
            System.out.println("\nНаходим максимальное слово в массиве!");
            BigWord.maxWordRunner();
        } else {
            System.out.println("Введено некорректное значение.");
            programTypeChoose();
        }
    }
}

