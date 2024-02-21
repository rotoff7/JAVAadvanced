package additionalTasks.task5;

import java.util.*;

public class Manipulations {

    public Manipulations() {
    }

    public Map<String, Integer> wordsCount(Set<String> list, ArrayList<String> words){
        Map<String, Integer> map = new HashMap<>();
        for (String value:list){
            map.put(value, 0);
        }
        for (String word:words) {
            if (map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }
        }
        return map;
    }

    public void printWordList(ArrayList<String> list){
        for (String word: list) {
            System.out.println(word);
        }
    }




}
