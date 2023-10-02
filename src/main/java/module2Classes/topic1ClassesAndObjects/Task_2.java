package module2Classes.topic1ClassesAndObjects;

import java.util.Scanner;

/**
 * Создайте класс, содержащий два поля типа int - числитель и знаменатель обыкновенной дроби.
 *
 * ○ Конструктор класса должен инициализировать эти два поля.
 *
 * ○ Создайте метод класса, который будет выводить дробь в текстовой строке в формате x / y;
 *
 * ○ Создайте метод, умножающий текущую дробь на число типа double, переданное методу в параметре и возвращающий дробь - результат умножения;
 *
 * ○ Создайте метод, делящий текущую дробь на число типа double, переданное ему в параметре и возвращающий дробь - результат деления.
 */
public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальные данные для дроби: ");
        System.out.print("Числитель (целое число): ");
        int numerator = scanner.nextInt();
        System.out.print("Знаменатель (целое число): ");
        int denominator = scanner.nextInt();

        RationalNumber number = new RationalNumber(numerator, denominator);
        System.out.print("\nПолучившаяся дробь: ");
        number.printFraction();

        System.out.print("\nВведите множитель для умножения дроби на это число (дробное число): ");
        double factor = scanner.nextDouble();

        RationalNumber multipliedNum = number.multiply(factor);
        multipliedNum.printFraction();

        System.out.print("Введите делитель для деления дроби на это число (дробное число): ");
        double divider = scanner.nextDouble();

        RationalNumber dividedNum = number.divide(divider);

    }
}

class RationalNumber {
    private final int numerator;
    private final int denominator;

    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }
        int gcd = getGreatestCommonDivisor(numerator, denominator);

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public void printFraction() {
        System.out.printf("%d / %d%n", numerator, denominator);
    }

    public RationalNumber multiply(double factor) {
        final int precision = 100;
        int factorNumerator = (int) (factor * precision);
        int factorDenominator = precision;

        RationalNumber normalizedFactor = new RationalNumber(factorNumerator, factorDenominator);
        return multiply(normalizedFactor);
    }

    public RationalNumber divide(double divider) {
        if (Double.compare(divider, 0.0) != 0) {
            final int precision = 100;
            int dividerNumerator = precision;
            int dividerDenominator = (int) (divider * precision);
            RationalNumber normalizedDivider = new RationalNumber(dividerNumerator, dividerDenominator);

            return multiply(normalizedDivider);
        } else {
            throw new IllegalArgumentException("Невозможно произвести деление на 0");
        }
    }

    private RationalNumber multiply (RationalNumber factor) {
        int newNumerator = numerator * factor.numerator;
        int newDenominator = denominator * factor.denominator;

        int gcd = getGreatestCommonDivisor(newNumerator, newDenominator);

        return new RationalNumber(newNumerator / gcd , newDenominator / gcd);
    }

    private int getGreatestCommonDivisor(int a, int b){
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}