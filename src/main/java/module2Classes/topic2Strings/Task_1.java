package module2Classes.topic2Strings;

import java.util.Scanner;

/**
 * Напишите метод, который принимает в качестве параметра любую строку, например “I like Java!!!”.
 *
 * 1) Распечатать последний символ строки.
 * 2) Проверить, заканчивается ли ваша строка подстрокой “!!!”.
 * 3) Проверить, начинается ли ваша строка подстрокой “I like”.
 * 4) Проверить, содержит ли ваша строка подстроку “Java”.
 * 5) Найти позицию подстроки “Java” в строке “I like Java!!!”.
 * 6) Заменить все символы “а” на “о”.
 * 7) Преобразуйте строку к верхнему регистру.
 * 8) Вырезать строку "Java" c помощью метода String.substring().
 *
 */
public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку для анализа: ");
        String str = scanner.nextLine();

        StringAnalyzer.printParsedData(str);
    }
}

class StringAnalyzer {
    public static void printParsedData(String str) {
        char lastChar = str.charAt(str.length() - 1);
        System.out.println(String.format("Последний символ строки: '%c'", lastChar));

        String suffix = "!!!";
        checkSuffix(str, suffix);

        String prefix = "I like";
        checkPrefix(str, prefix);

        String substring = "Java";
        checkSubstring(str, substring);

        checkPositionSubstring(str, substring);

        char oldChar = 'a';
        char newChar = 'o';
        replaceChars(str, oldChar, newChar);

        System.out.println("Строка в верхнем регистре: " + str.toUpperCase());

        String strToDelete = "Java";
        deleteSubstring(str, strToDelete);
    }

    private static void checkSuffix(String str, String suffix) {
        if (str.endsWith(suffix)) {
            System.out.println(String.format("\nСтрока заканчивается на '%s'", suffix));
        } else {
            System.out.println(String.format("\nСтрока не заканчивается на '%s'", suffix));
        }
    }

    private static void checkPrefix(String str, String prefix) {
        if (str.startsWith(prefix)) {
            System.out.println(String.format("Строка содержит в начале подстроку '%s'", prefix));
        } else {
            System.out.println(String.format("Строка не содержит в начале подстроку '%s'", prefix));
        }
    }

    private static void checkSubstring(String str, String substring) {
        if (str.contains(substring)) {
            System.out.println(String.format("Строка содержит в себе подстроку '%s'", substring));
        } else {
            System.out.println(String.format("Строка не содержит в себе подстроку '%s'", substring));
        }
    }

    private static void replaceChars(String str, char oldChar, char newChar) {
        System.out.println(String.format("\nСтрока с замененными символами '%c' на '%c': %s",
                oldChar, newChar, str.replace(oldChar, newChar)));
    }

    private static void checkPositionSubstring(String str, String substring) {
        System.out.println(String.format("Позиция начала подстроки '%s' в строке: %d",
                substring, str.indexOf(substring)));
    }

    private static void deleteSubstring(String str, String strToDelete) {
        int deleteFromIndex = str.indexOf(strToDelete);
        int deleteToIndex = deleteFromIndex + strToDelete.length();

        if (deleteFromIndex != -1) {
            String strAfterDelete = str.substring(0, deleteFromIndex) + str.substring(deleteToIndex);
            System.out.println(String.format("Строка после удаления подстроки '%s': '%s'", strToDelete, strAfterDelete));
        }
    }
}

