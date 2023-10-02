package module1Basics.topic1DataTypes;

/**
 * Написать метод, который принимает на вход два целых числа, делает их
 *
 * суммирование и складывает результат с произведением двух этих чисел, и
 * возвращает полученный результат из метода.
 * Передать на вход в метод любые два числа.
 * Вывести полученный результат работы метода на экран.
 */
public class Task_2 {
    public static void main(String[] args) {
        int sumAndProduct = getSumAndProduct(10, 5);
        System.out.println(sumAndProduct);
    }

    public static int getSumAndProduct(int a, int b) {
        return (a + b) + a *b;
    }
}
