package module4Collections.topic2Maps;

import java.util.*;

/**
 * Написать программу преобразующую римские цифры в арабские.
 */
public class Task_4 {
    private static final Map<Character, Integer> ROMAN_TO_ARABIC =
            new HashMap<>() {{
                put('C', 100);
                put('L', 50);
                put('X', 10);
                put('V', 5);
                put('I', 1);
            }};

    private static final NavigableMap<Integer, Character> ARABIC_TO_ROMAN =
            new TreeMap<>() {{
                put(100, 'C');
                put(50, 'L');
                put(10, 'X');
                put(5, 'V');
                put(1, 'I');
            }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число в римской записи: ");
        String numberRoman = scanner.nextLine();

        int arabicNumber = parseRomanNumber(numberRoman);

        if (arabicNumber != -1) {
            System.out.printf("Число '%s' в арабской записи: '%d'\n", numberRoman,
                    arabicNumber);
        } else {
            System.out.printf("Ошибка в записи числа '%s'\n", numberRoman);
        }
    }

    public static int parseRomanNumber(String str) {
        char lastSymbol = str.charAt(0);
        int symbolCount = 0;
        int result = 0;

        for (char ch: str.toCharArray()) {
            if (ch == lastSymbol) {
                symbolCount++;
            } else if (ROMAN_TO_ARABIC.get(ch) > ROMAN_TO_ARABIC.get(lastSymbol)) {
                result -= ROMAN_TO_ARABIC.get(lastSymbol) * 2;
                symbolCount = 1;
            } else {
                symbolCount = 1;
            }
            lastSymbol = ch;

            if (symbolCount == 4 || !ROMAN_TO_ARABIC.containsKey(ch)) {
                return -1;
            }

            result += ROMAN_TO_ARABIC.get(ch);
        }

        return result;
    }
}