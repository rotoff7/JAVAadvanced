package additionalTasks.task5;

import java.util.*;

public class Manipulations {

    public Manipulations() {
    }

    /**
     * Сперва создаем set и отсекает дубликаты слов,
     * записываем слова в ключ map-ы и выставляем всем кол-во повторений = 0.
     * После чего проходим по нашему массива слов (с повторениями)
     * и для каждого совпадения увеличиваем каунтер в мапе на 1
     *
     * @param words наш массив слов из файла
     * @return map возвращает пары: слово - кол-во повтороений
     */
    public Map<String, Integer> wordsCount(ArrayList<String> words) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(words);
        for (String value : set) {
            map.put(value, 0);
        }
        // Не очень нравится двойной проход по массивам.
        // Думаю, что тут можно выполнить подсчет за один цикл, но идея реализации не пришла
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
        }
        return map;
    }

    public void fileWasNotEmpty(ArrayList<String> list){
        if (list.isEmpty()){
            System.out.println("Файл пуст.");
            System.exit(0);
        }
    }

    public void printMostPopularWord(Map<String, Integer> map) {
        int maxCount = Collections.max(map.values());
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getValue() == maxCount) {
                System.out.printf("Самое часто встречаемое слово = %s. Встречается в файле - %d раз(а).",
                        pair.getKey(), pair.getValue());
                break;
            }
        }
    }

    public void printWordList(ArrayList<String> list) {
        StringBuilder oneLine = lineBuilder(list);
        System.out.println(oneLine);
        System.out.println();
    }

    /**
     * Метод создает экземпляр StringBuilder-а и записывает в него по 10 слов на одну строку.
     * @param list Принимает распарсенный по словам файл
     * @return выводим нужный для вывода в консоль StringBuilder
     */
    private StringBuilder lineBuilder(ArrayList<String> list) {
        StringBuilder oneLine = new StringBuilder();
        int temp = 0;
        for (String word : list) {
            if (temp != 9) {
                oneLine.append(word).append(", ");
                temp++;
            } else {
                oneLine.append(word).append("\n");
                temp = 0;
            }
        }
        return oneLine;
    }


}
