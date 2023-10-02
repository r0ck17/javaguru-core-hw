package module2Classes.topic2Strings;

import java.util.List;
import java.util.Scanner;

/**
 * Написать метод, принимающий на вход слово и возвращающий true если слово является палиндромом.
 * Палиндром - слово, которое при чтении в справа на лево не меняет значения.
 * Пример - "шалаш", если перевернуть слово, то ничего не измениться.
 * <p>
 * Допущения:
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */
public class Task_5 {
    public static void main(String[] args) {
        for (String str : List.of("aba", "abca", "abc")) {
            printPalindromeInfo(str);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String word = scanner.nextLine();
        printPalindromeInfo(word);
    }

    private static void printPalindromeInfo(String str) {
        System.out.printf(
                "Строка %s %sявляется палиндромом (учитывается возможность" +
                        " удаления одного любого символа).%n",
                str,
                validPalindrome(str) ? "" : "не ");
    }

    public static boolean validPalindrome(String str) {
        String normalizedStr = str.toLowerCase().trim();
        if (normalizedStr.isEmpty()) {
            return true;
        }
        int p1 = 0, p2 = str.length() - 1;

        while (p1 <= p2) {
            if (str.charAt(p1) != str.charAt(p2)) {
                return isPalindrome(normalizedStr.substring(p1, p2))
                        || isPalindrome(normalizedStr.substring(p1 + 1, p2 + 1));
            }
            p1++;
            p2--;
        }

        return true;
    }

    public static boolean isPalindrome(String word) {
        String str = word.toLowerCase().trim();
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}

