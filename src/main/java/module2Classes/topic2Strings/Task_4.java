package module2Classes.topic2Strings;

import java.util.Scanner;

/**
 * Даны строки разной длины (длина - четное число),
 * необходимо вернуть ее два средних знака. Например, если дана строка "string"
 * результат будет "ri", для строки "code" результат "od", для "Practice" результат "ct".
 */
public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String str = scanner.nextLine();

        System.out.printf("Два центральных символа: '%s'\n", getTwoMiddleChars(str));
    }

    public static String getTwoMiddleChars(String str) {
        int length = str.length();
        if (length < 3) {
            return "";
        }

        int midIndex = length / 2;
        if (length % 2 == 0) {
            return str.substring(midIndex - 1, midIndex + 1);
        }

        return String.valueOf(str.charAt(midIndex));
    }
}
