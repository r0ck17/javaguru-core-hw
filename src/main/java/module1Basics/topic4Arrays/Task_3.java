package module1Basics.topic4Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Создать двухмерный квадратный массив и заполнить его «бабочкой», то есть таким образом:
 *
 * 1 1 1 1 1
 * 0 1 1 1 0
 * 0 0 1 0 0
 * 0 1 1 1 0
 * 1 1 1 1 1
 */
public class Task_3 {
    public static void main(String[] args) {
        System.out.print("Введите размер массива для его заполнения в стиле \"бабочки\": ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] matrix = generateButterFlyPatternArray(size);

        System.out.println("Сгенерированный квадратный массив:");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] generateButterFlyPatternArray(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            int offsetFromEdge = i < size / 2 ? i : size - i - 1;
            for (int j = offsetFromEdge; j < size - offsetFromEdge; j++) {
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }
}
