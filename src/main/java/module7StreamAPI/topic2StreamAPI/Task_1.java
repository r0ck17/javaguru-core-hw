package module7StreamAPI.topic2StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class Task_1 {
    public static void main(String[] args) {
        Collection<String> lines = List.of("try.", "test", "Some.word", "hello",
                "Test test2", "java developer");

        String key = "login";
        boolean containsWord = isContainsWord(lines, key);
        System.out.println("Contains " + key + ": " + containsWord);

        String maxLengthSting = getMaxLengthString(lines);
        System.out.println("Max length string: " + maxLengthSting);

        String minLengthSting = getMinLengthString(lines);
        System.out.println("Min length string: " + minLengthSting);

        List<String> filteredLines = filterLinesWithoutPunct(lines);
        System.out.println("\nfiltered lines:");
        System.out.println(filteredLines);

        Set<String> words = getAllWords(lines);
        System.out.println("\nall words:");
        System.out.println(words);
    }

    private static Set<String> getAllWords(Collection<String> lines) {
        return lines.stream()
                .flatMap(line -> Arrays.stream(line.toLowerCase().split(" ")))
                .collect(Collectors.toSet());
    }

    private static List<String> filterLinesWithoutPunct(Collection<String> lines) {
        return lines.stream()
                .filter(x -> !containsPunctChars(x))
                .toList();
    }

    private static String getMinLengthString(Collection<String> lines) {
        return lines.stream()
                .min(Comparator.comparing(String::length))
                .orElse("Not found");
    }

    private static String getMaxLengthString(Collection<String> lines) {
        return lines.stream()
                .max(Comparator.comparing(String::length))
                .orElse("Not found");
    }

    private static boolean isContainsWord(Collection<String> lines, String key) {
        return lines.stream().anyMatch(key::equals);
    }

    private static boolean containsPunctChars(String s) {
        Set<Character> punctChars = new HashSet<>() {{
            add(' ');
            add('.');
            add(',');
        }};

        return s.chars()
                .mapToObj(c -> (char) c)
                .anyMatch(punctChars::contains);
    }
}
