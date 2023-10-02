package module4Collections.topic3CollectionsSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Сортировка Map по значению
 *
 * Есть map:
 *
 * Map<String, Integer> nonSortedMap = Map.of(
 *        "two", 2,
 *        "five", 5,
 *        "three", 3,
 *        "one", 1,
 *        "four", 4
 *
 * );
 *
 * Написать метод sortByValue который сортирует карту по ее значениям:
 *
 * Map<String, Integer> sortedMap = sortByValue(nonSortedMap);
 *
 * Вывод:
 * one=1
 * two=2
 * three=3
 * four=4
 */
public class Task_2 {
    public static void main(String[] args) {
        Map<String, Integer> nonSortedMap = Map.of(
                "two", 2,
                "five", 5,
                "three", 3,
                "one", 1,
                "four", 4
        );
        System.out.println("Initial map:");
        System.out.println(nonSortedMap);

        Map<String, Integer> sortedMap = sortByValue(nonSortedMap);

        System.out.println("\nMap after sorting:");
        System.out.println(sortedMap);
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {
        ArrayList<Map.Entry<String, Integer>> mapEntries = new ArrayList<>(unsortedMap.entrySet());
        mapEntries.sort(new EntryValueComparator());

        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> mapEntry : mapEntries) {
            sortedMap.put(mapEntry.getKey(), mapEntry.getValue());
        }

        return sortedMap;
    }
}

class EntryValueComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
}
