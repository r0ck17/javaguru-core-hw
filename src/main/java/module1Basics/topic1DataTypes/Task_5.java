package module1Basics.topic1DataTypes;

import java.util.Scanner;

/**
 * 1. Написать метод, принимающий на вход четырехзначное число abcd и возвращающий сумму ab + cd
 * 2. Получать число abcd через scanner в методе main
 */
public class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int result = getResult(input);

        System.out.println(result);
    }

    public static int getResult(int num) {
        int a = num / 1000;
        int b = (num % 1000) / 100;
        int c = (num % 100) / 10;
        int d = num % 10;

        return a * b + c * d;
    }
}
