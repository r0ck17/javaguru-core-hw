package module1Basics.topic2ConditionStatements;

import java.util.Scanner;

/**
 * Задать целое число в виде переменной, это число – сумма денег в рублях.
 * Вывести это число на экран, добавив к нему слово «рублей» в правильном падеже.
 */
public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rubles = scanner.nextInt();

        String formattedLineWithRubles = getFormattedLineWithRubles(rubles);
        System.out.println(formattedLineWithRubles);
    }

    public static String getFormattedLineWithRubles(int rubles) {
        int lastDigit = rubles % 10;
        int lastTwoDigits = rubles % 100;

        String rublesWord = "";

        if (lastDigit == 1 && lastTwoDigits != 11) {
            rublesWord = "рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4 && (lastTwoDigits >= 20 || lastTwoDigits < 5)) {
            rublesWord = "рубля";
        } else {
            rublesWord = "рублей";
        }

        return rubles + " " + rublesWord;
    }
}
