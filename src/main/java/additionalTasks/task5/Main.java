package additionalTasks.task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    // Вычитывание слов из файла + сортировка + подсчет кол-во повторений слов в файле и вывод этой статистики
    //TODO Вывод сортированного списка по 5-10 слов в одной строке
    //TODO Найти самое частое слово и вывести его на консоль вместе с кол-вом повторений
    //TODO Раскидать методы по классам, проверить нейминг
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/Words.txt");
        Manipulations fileActions = new Manipulations();
        ArrayList<String> textFromFile;

        textFromFile = parsFile(file);

        Collections.sort(textFromFile);
        System.out.println("Отсортированный тектс файла:");
        fileActions.printWordList(textFromFile);

        Set<String> set = new HashSet<>(textFromFile);

        Map<String, Integer> wordsCountMap = fileActions.wordsCount(set, textFromFile);

        for (Map.Entry<String, Integer> entry : wordsCountMap.entrySet()) {
            System.out.println("Слово \"" + entry.getKey() + "\" встречается в файле: " + entry.getValue() + " раз(а).");
        }
    }

    public static ArrayList<String> parsFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<String> wordList = new ArrayList<>();
        while (scanner.hasNext()) {
            wordList.add(scanner.next());
        }
        scanner.close();
        return wordList;
    }
}
