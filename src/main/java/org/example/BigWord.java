package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class BigWord {
    private static Scanner scan;
    private static String[] wordList;
    private static int maxLength;
    private static int wordIndex;

    private static int arraySize;

    static void maxWordRunner() {
        scan = new Scanner(System.in);
        System.out.print("Задайте размер массива: ");
        arraySizeInput();
        arrayFiller();
        findMaxWordLength();
        answerPrint();
    }

    private static void arraySizeInput() {
        try {
            arraySize = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Некорректный ввод. Размером массива может являться положительное число");
            maxWordRunner();
        }
        if (arraySize <= 0) {
            System.out.println("Некорректный ввод. Размером массива может являться положительное число");
            maxWordRunner();
        }
    }

    private static void arrayFiller() {
        wordList = new String[arraySize];
        for (int i = 1; i < wordList.length + 1; i++) {
            System.out.print("Введите " + i + "-e слово:");
            wordList[i - 1] = scan.next();
        }
    }

    private static void findMaxWordLength() {
        maxLength = wordList[0].length();
        wordIndex = 0;
        for (int i = 0; i < wordList.length; i++) {
            if (wordList[i].length() > maxLength) {
                maxLength = wordList[i].length();
                wordIndex = i;
            }
        }
    }

    private static void answerPrint() {
        System.out.printf("Самое длинное слово - %s. " +
                "\nДлина самого длинного слова в массиве = %s, " +
                "слово располагается на %s месте.", wordList[wordIndex], maxLength, wordIndex + 1);
        oneMoreTime();
    }

    private static void oneMoreTime() {
        System.out.print("\nСыграем еще раз? Да/Нет: ");
        String oneMore = scan.next().toLowerCase(Locale.ROOT);
        switch (oneMore) {
            case ("да"):
                maxWordRunner();
            case ("нет"):
                System.out.println("До свидания!");
                scan.close();
                System.exit(0);
                break;
            default:
                System.out.println("Выбрана некорректная команда, повторите ввод.");
                oneMoreTime();
        }
    }
}
