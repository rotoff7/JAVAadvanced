package additionalTasks;

import java.util.Random;

public class Task3Part1 {

    private static boolean positive = false;
    private static boolean negative = false;
    private static int positiveStartPoint;
    private static int negativeStartPoint;

    /**
     * Точка входа и основной метод программы, где:
     * Спера инициирование массива с размерностью 20 (по условию),
     * его наполнение и определение наличия положительных и отрицательных чисел
     * @see #arrayFillAndCheck(int[])
     * Если положительный и отрицательные числа присутствуют в массиве, то выполняем определение
     * положений искомых элементов в массиве и меняем их местами.
     * Результаты выводятся в консоль.
     * @see #arrayPrint(int[]) 
     */
    public static void main(String[] args) {
        int[] array = new int[20];
        arrayFillAndCheck(array);
        if (!positive || !negative) {
            System.out.println("\nВ массиве нет положительных или отрицательных чисел. Невозможно выполнить перестановку.");
            System.exit(0);
        }
        System.out.print("\nДо перестановки элементов.");
        arrayPrint(array);
        elementSwap(array, maxNegativeElement(array), minPositiveElement(array));
        System.out.print("\nПосле перестановки элементов.");
        arrayPrint(array);
    }

    /**
     * Заполняет массив случайными числами в диапазоне [-10 ; 10].
     * Определяет есть ли в массиве хоть одно положительное
     * и отрицательное число и сохраняет их индексы (первое попавшееся).
     * Это необходимо  для обработки ситуации, когда в массиве будет отсутствовать одна из категорий чисел,
     * и определения числа от которого отталкиваться при переборе значений (нельзя просто указать первый элемент)
     *
     * @param arr передаваемый в метод инициализированный массив
     * @return возвращаем заполненный числами массив
     */
    private static int[] arrayFillAndCheck(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int minNum = -10;
            int maxNum = 10;
            arr[i] = random.nextInt((maxNum - minNum) + 1) + minNum;
            if (!positive && arr[i] >= 0) {
                positive = true;
                positiveStartPoint = i;
            } else if (!negative && arr[i] < 0) {
                negative = true;
                negativeStartPoint = i;
            }
        }
        return arr;
    }

    // Определяем позицию минимального положительного числа массива
    private static int minPositiveElement(int[] arr) {
        int minPositiveIndex = positiveStartPoint;
        int minPositiveValue = arr[positiveStartPoint];
        for (int i = positiveStartPoint; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] < minPositiveValue) {
                minPositiveValue = arr[i];
                minPositiveIndex = i;
            }
        }
        System.out.printf("\nМинимальный положительный элемент массива = %d, впервые встречается под индексом: %d",
                minPositiveValue, minPositiveIndex);
        return minPositiveIndex;
    }

    // Определяем позицию максимального отрицательного числа массива
    private static int maxNegativeElement(int[] arr) {
        int maxNegativeIndex = negativeStartPoint;
        int maxNegativeValue = arr[negativeStartPoint];
        for (int i = negativeStartPoint; i < arr.length; i++) {
            if (arr[i] < 0 && arr[i] > maxNegativeValue) {
                maxNegativeValue = arr[i];
                maxNegativeIndex = i;
            }
        }
        System.out.printf("\nМаксимальный отрицательный элемент массива = %d, впервые встречается под индексом: %d",
                maxNegativeValue, maxNegativeIndex);
        return maxNegativeIndex;
    }

    /**
     * Производим свап элементов по найденны индексам
     * @see #maxNegativeElement(int[])
     * @see #minPositiveElement(int[])
     */
    private static void elementSwap(int[] arr, int maxNegIndex, int minPosIndex) {
        int temp = arr[maxNegIndex];
        arr[maxNegIndex] = arr[minPosIndex];
        arr[minPosIndex] = temp;
    }

    // Метод для вывода значений массива в консоль
    private static void arrayPrint(int[] arr) {
        System.out.println();
        System.out.print("Вывод массива чисел: ");
        for (int element : arr) {
            System.out.print(element + ", ");
        }
    }
}
