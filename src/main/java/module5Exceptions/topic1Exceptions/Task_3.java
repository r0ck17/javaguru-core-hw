package module5Exceptions.topic1Exceptions;

/**
 * 1. Написать метод, который будет возбуждать исключение и обработать это исключение на уровне выше. (В коде, который вызывает метод)
 * 2. Результат работы программы вывести на экран.
 */
public class Task_3 {
    public static void main(String[] args) {
        try {
            divideNumbers(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Деление на 0 запрещено.");
        }
    }

    public static double divideNumbers(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }
}
