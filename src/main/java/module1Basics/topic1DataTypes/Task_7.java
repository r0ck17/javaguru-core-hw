package module1Basics.topic1DataTypes;

import java.util.Scanner;

/**
 * Написать метод, принимающий на вход координаты двух точек и возвращающий длину отрезка между этими точками.
 * При тестировании координаты вводить с клавиатуры.
 * Подсказка: использовать класс Math и формулу расчета отрезка по координатам двух точек.
 */
public class Task_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        double segmentLength = getSegmentLength(x1, y1, x2, y2);

        System.out.printf("%.2f%n", segmentLength);
    }

    public static double getSegmentLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
