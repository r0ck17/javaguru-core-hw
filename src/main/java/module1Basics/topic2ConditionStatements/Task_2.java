package module1Basics.topic2ConditionStatements;

import java.util.Scanner;

/**
 * Есть прямоугольное отверстие размерами a и b, где a и b – целые числа.
 * Определить, можно ли его полностью закрыть круглой картонкой радиусом r (тоже целое число).
 */
public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int r = scanner.nextInt();
        boolean circleCoverRectangle = isCircleCanCoverRectangle(a, b, r);

        if (circleCoverRectangle) {
            System.out.println("Отверстие можно закрыть круглой картонкой");
        } else {
            System.out.println("Отверстие нельзя закрыть круглой картонкой");
        }
    }

    public static boolean isCircleCanCoverRectangle(int a, int b, int r) {
        double diagonal = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return diagonal / 2.0 <= r;
    }
}
