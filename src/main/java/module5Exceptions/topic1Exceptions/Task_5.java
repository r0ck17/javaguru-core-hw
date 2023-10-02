package module5Exceptions.topic1Exceptions;

import java.util.Random;
import java.util.Scanner;

/**
 * 1. Реализуйте игру “Угадай число” от 1 до 100 с подсказкой - “искомое число больше/меньше”.
 *      Т.е. в программе генерируется случайное число от 1 до 100, с консоли вводите свое число, если угадали, то выиграли,
 *      если нет, то программа выводит сообщение, что ваше число больше/меньше искомого и позволяет сделать еще 4 попытки. Если так и не угадали - проиграли.
 *
 * 2. Если введено не число, то генерировать исключение и выводить сообщение об ошибке с подсказкой,
 *      что надо ввести, и продолжить работу программы.
 *
 * 3. Если введено некорректное число, то выводить сообщение об ошибке на консоль с подсказкой,
 *      что должно быть введено число в диапазоне от 1 до 100 и продолжить работу программу.
 *
 * 4. Если введено число в диапазоне от 1 до 100, но оно не равно искомому числу, то надо вывести подсказу и продолжить работу программы.
 *      Это можно реализовать с помощью исключений, можно через обычные условные операторы.
 *
 */
public class Task_5 {
    private static final int MAX_ATTEMPTS = 5;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 32;

    public static void main(String[] args) {
        playGameGuessNumber(MAX_ATTEMPTS, MIN_NUMBER, MAX_NUMBER);
    }

    public static void playGameGuessNumber(int maxAttempts, int minNumber,
                                           int maxNumber) {
        Random random = new Random();
        int secretNumber = random.nextInt(maxNumber) + 1;
        int attempts = maxAttempts;
        System.out.printf("Это игра \"Угадай число\", загадано число от %d до %d." +
                " Удачи!\n", minNumber, maxNumber);

        while (attempts > 0) {
            System.out.printf("\nОставшееся число попыток: %d\n", attempts);
            int input = getNumber(minNumber, maxNumber);

            if (input == secretNumber) {
                System.out.println("\nПоздравляем, вы отгадали число!");
                return;
            } else if (attempts != 0) {
                String tip = input > secretNumber ? "меньше" : "больше";
                System.out.printf("\nПодсказка: " +
                        "указанное число %s загаданного.", tip);
            }

            attempts--;
        }
        System.out.printf("\nПопыток больше нет, игра окончена." +
                " Загаданное число: %d\n", secretNumber);
    }

    private static int getNumber(int minNumber, int maxNumber) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Введите число (от %d до %d): ",
                    minNumber, maxNumber);
            try {
                String str = scanner.nextLine();
                int input = Integer.parseInt(str);

                if (input < minNumber || input > maxNumber) {
                    throw new IllegalArgumentException();
                } else {
                    return input;
                }
            } catch (NumberFormatException  e) {
                System.out.print("Некорректный ввод. Необходимо ввести целое число. ");
            } catch (IllegalArgumentException e) {
                System.out.printf("Ошибка. Число должно быть в диапазоне от %d " +
                        "до %d.\n", minNumber, maxNumber);
            }
        }
    }
}