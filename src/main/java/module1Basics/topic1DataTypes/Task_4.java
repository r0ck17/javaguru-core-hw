package module1Basics.topic1DataTypes;

import java.util.Scanner;

/**
 * 1. Написать метод getLastDigit(int number), который принимает на вход число, а возвращает последнюю цифру этого числа.
 *
 * 2. В методе main получить число, введенное с клавиатуры, затем вызвать метод getLastDigit, передав ему это число. Вывести на экран результат выполнения метода.
 *
 * Подсказка:
 * Прочитать число, введенное с клавиатуры:
 * Scanner sc= new Scanner(System.in);
 * int number = sc.nextInt();
 */
public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int lastDigit = getLastDigit(input);

        System.out.println(lastDigit);
    }

    public static int getLastDigit(int number) {
        return number % 10;
    }
}
