package module1Basics.topic3Loops;

import java.util.Scanner;

/**
 * Поделить пиццу.
 *
 * 1.Через System.in вводить:
 * - количество людей
 * - количество кусков в одной пицце
 * 2. Вывести на экран минимальное количество пицц, чтобы у всех было одинаковое
 * количество кусков и ни одного не осталось лишнего в коробке.
 */
public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество людей: ");
        int peopleCount = scanner.nextInt();
        System.out.print("Введите количество кусочков в одной пицце: ");
        int piecesInOnePizza = scanner.nextInt();

        int pizzasCount = 1;

        while ((pizzasCount * piecesInOnePizza) % peopleCount != 0) {
            pizzasCount++;
        }

        System.out.println("Минимальное количество пицц для равного числа кусков на каждого человека: " + pizzasCount);
    }
}
