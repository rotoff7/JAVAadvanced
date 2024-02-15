package additionalTasks;

import java.util.Random;

public class Task3Part1 {

    public static void main(String[] args) {
        Random random = new Random();
        int maxNum = 10;
        int minNum = -10;
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt((maxNum - minNum) + 1) + minNum;
        }
        System.out.print("\nДо перестановки элементов.");
        arrayPrint(array);
        elementSwap(array, minElement(array), maxElement(array));
        System.out.print("\nПосле перестановки элементов.");
        arrayPrint(array);
    }

    private static int maxElement(int[] arr) {
        int maxIndex = 0;
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        System.out.printf("\nМаксимальный элемент массива: %d, впервые встречается под индексом: %d",
                maxValue, maxIndex);
        return maxIndex;
    }

    private static int minElement(int[] arr) {
        int minIndex = 0;
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }
        System.out.printf("\nМинимальный элемент массива: %d, впервые встречается под индексом: %d",
                minValue, minIndex);
        return minIndex;
    }

    private static void elementSwap(int[] arr, int minIndex, int maxIndex){
        int temp = arr[minIndex];
        arr[minIndex] = arr[maxIndex];
        arr[maxIndex] = temp;
    }

    private static void arrayPrint(int[] arr){
        System.out.println();
        System.out.print("Вывод массива чисел: ");
        for (int element:arr) {
            System.out.print(element + ", ");
        }
    }
}
