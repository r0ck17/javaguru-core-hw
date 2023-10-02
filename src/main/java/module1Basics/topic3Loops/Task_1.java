package module1Basics.topic3Loops;

/**
 * Вычислить факториал целых чисел от 1 до 10 с помощью цикла while.
 */
public class Task_1 {
    public static void main(String[] args) {
        int factorial = 1;
        int currNumber = 1;

        while (currNumber <= 10) {
            factorial *= currNumber;
            System.out.println(currNumber +"! = " + factorial);
            currNumber++;
        }
    }
}
