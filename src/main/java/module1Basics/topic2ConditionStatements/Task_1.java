package module1Basics.topic2ConditionStatements;

import java.util.Scanner;

/**
 * Создайте метод с одним целочисленным параметром.
 * Метод должен определить, является ли последняя цифра числа семеркой и вернуть boolean значение.
 */
public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        boolean lastDigitSeven = isLastDigitSeven(input);

        System.out.println(lastDigitSeven);
    }

    public static boolean isLastDigitSeven(int num) {
        return (num % 10) == 7;
    }
}
