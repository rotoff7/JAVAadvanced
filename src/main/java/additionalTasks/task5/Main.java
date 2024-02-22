package additionalTasks.task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/Words.txt");
        Manipulations actions = new Manipulations();
        ArrayList<String> textFromFile = parseFile(file);

        Collections.sort(textFromFile);

        System.out.println("\nОтсортированный текст файла:");
        actions.printWordList(textFromFile);

        Map<String, Integer> wordsCountMap = actions.wordsCount(textFromFile);

        for (Map.Entry<String, Integer> entry : wordsCountMap.entrySet()) {
            System.out.println("Слово \"" + entry.getKey() + "\" встречается в файле: " + entry.getValue() + " раз(а).");
        }
        System.out.println("-------------------------------------------------");

        actions.printMostPopularWord(wordsCountMap);
    }

    private static ArrayList<String> parseFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<String> wordList = new ArrayList<>();
        while (scanner.hasNext()) {
            wordList.add(scanner.next());
        }
        scanner.close();
        return wordList;
    }
}
