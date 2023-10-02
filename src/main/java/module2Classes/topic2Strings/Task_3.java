package module2Classes.topic2Strings;

import java.util.Scanner;

/**
 * Написать метод, принимающий на вход слово и возвращающий true если слово является палиндромом.
 * Палиндром - слово, которое при чтении в справа на лево не меняет значения.
 * Пример - "шалаш", если перевернуть слово, то ничего не измениться.
 */
public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для проверки, является ли оно палиндромом: ");
        String str = scanner.nextLine();

        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        String normalizedStr = str.toLowerCase().trim();
        if (normalizedStr.isEmpty()) {
            return true;
        }
        int p1 = 0, p2 = str.length() - 1;

        while (p1 <= p2) {
            if (str.charAt(p1) != str.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }

        return true;
    }
}
