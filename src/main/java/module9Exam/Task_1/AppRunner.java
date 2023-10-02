package module9Exam.Task_1;

import java.util.Random;

import static java.lang.Math.*;

/**
 * Сгенерировать три произвольных целых числа x, y и z.
 *
 * Если x больше z, то вывести на экран сумму x и y
 * если z больше y, то вывести на экран среднее арифметическое всех чисел
 * иначе вывести остаток от деления y на z.
 */
public class AppRunner {
    private static final int MAX_NUMBER = 75;
    private static final int MIN_NUMBER = -50;

    public static void main(String[] args) {
        Random random = new Random();

        int x = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        int y = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        int z = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        System.out.printf("x=%d y=%d z=%d%n", x, y, z);

        if (x > z) {
            System.out.printf("x + y = %d%n", x + y);
        } else if (z > y) {
            System.out.printf("avg(x, y, z) = %.2f%n",
                    (abs(x) + abs(y) + abs(z)) / 3.0);
        } else {
            System.out.printf("y %% z = %d%n", abs(y) % abs(z));
        }
    }
}
