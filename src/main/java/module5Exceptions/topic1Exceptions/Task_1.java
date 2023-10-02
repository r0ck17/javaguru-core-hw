package module5Exceptions.topic1Exceptions;

import java.util.List;

/**
 * 1. Написать код, который выбрасывает NullPointerException.
 * 2. Написать обработчик этого исключения и вывести на экран сообщение, которое будет содержать описание данного исключения.
 */
public class Task_1 {
    public static void main(String[] args) {
        try {
            List<Integer> numbers = getAllEvenNumbers(1, 100);
            int evenNumbersCount = numbers.size();
            System.out.println("List size: " + evenNumbersCount);
        } catch (NullPointerException e) {
            System.out.println("Возникло исключение: " + e);
        }
    }

    public static List<Integer> getAllEvenNumbers(int from, int to) {
        // wrong method implementation
        return null;
    }
}