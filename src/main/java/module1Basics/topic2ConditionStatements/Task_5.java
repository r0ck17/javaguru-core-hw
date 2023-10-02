package module1Basics.topic2ConditionStatements;

import java.util.Scanner;

/**
 * Коэффициенты a,b,c квадратного уравнения задаются через System.in.
 * Надо вывести на экран один или два корня уравнения если они есть, иначе вывести на экран “Корней нет”.
 * Параметр a гарантированно не равен 0.
 */
public class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("Корней нет");
        } else if (discriminant == 0) {
            double x = (double) -b / (2 * a);
            System.out.println("x = " + String.format("%.2f", x));
        } else {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("x1 = " + String.format("%.2f", x1));
            System.out.println("x2 = " + String.format("%.2f", x2));
        }
    }
}
