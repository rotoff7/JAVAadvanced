package additionalTasks.task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static ArrayList<String> textFromFile = null;
    private static File file;
    private static final Manipulations actions = new Manipulations();

    public static void main(String[] args) {
        file = new File("src/main/resources/Words.txt");
        // Если файл существует - парсим
        try {
            textFromFile = parseFile();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            System.exit(0);
        }
        actions.fileWasNotEmpty(textFromFile); // Проверяем, что файл не был пуст

        Collections.sort(textFromFile); // Сортируем слова в файле и выводим их в консоль
        System.out.println("\nОтсортированный текст файла:");
        actions.printWordList(textFromFile);

        Map<String, Integer> wordsCountMap = actions.wordsCount(textFromFile);
        // Подсчитываем сколько раз встречалось каждое слово и выводим статистику в консоль
        for (Map.Entry<String, Integer> entry : wordsCountMap.entrySet()) {
            System.out.println("Слово \"" + entry.getKey() + "\" встречается в файле: " + entry.getValue() + " раз(а).");
        }
        System.out.println("-------------------------------------------------");

        actions.printMostPopularWord(wordsCountMap); // Выводим информацию о самом популярном слове в файле
    }

    private static ArrayList<String> parseFile() throws FileNotFoundException { //Возможно стоило вынести метод отдельно
        Scanner scanner = new Scanner(file);
        ArrayList<String> wordList = new ArrayList<>();
        while (scanner.hasNext()) {
            wordList.add(scanner.next());
        }
        scanner.close();
        return wordList;
    }
}
