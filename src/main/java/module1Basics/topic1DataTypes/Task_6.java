package module1Basics.topic1DataTypes;

import java.util.Scanner;

/**
 * 1. Написать метод, принимающий на вход 5ти-значное число и возвращающий 3юю цифру.
 * 2. При тестировании метода, число вводить с клавиатуры
 */
public class Task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int result = getThirdDigit(input);

        System.out.println(result);
    }

    public static int getThirdDigit(int num) {
        return (num % 1000) / 100;
    }
}
