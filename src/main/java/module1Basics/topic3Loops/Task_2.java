package module1Basics.topic3Loops;

/**
 * Посчитать сумму цифр числа 7893823445 с помощью цикла do while.
 */
public class Task_2 {
    public static void main(String[] args) {
        long number = 7893823445L;
        int result = getSumAllDigits(number);
        System.out.println(result);
    }

    public static int getSumAllDigits(long num) {
        long normalizedNum = Math.abs(num);
        int sum = 0;
        do {
            sum += normalizedNum % 10;
            normalizedNum /= 10;
        } while (normalizedNum > 0);

        return sum;
    }
}
