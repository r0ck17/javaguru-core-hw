package module1Basics.topic3Loops;

/**
 * Найти среди чисел от 50 до 70 второе простое число
 * (число называют простым, если оно делится без остатка только на 1 и себя)
 * и завершить цикл с  использованием break.
 */
public class Task_3 {
    public static void main(String[] args) {
        int countPrimes = 0;
        for (int i = 50; i <= 70; i++) {
            if (isPrimeNumber(i)) {
                countPrimes++;
            }
            if (countPrimes == 2) {
                System.out.println("Второе простое число в диапазоне [50, 70] = " + i);
                break;
            }
        }
    }

    public static boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
