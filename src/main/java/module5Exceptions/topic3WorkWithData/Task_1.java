package module5Exceptions.topic3WorkWithData;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

/**
 *             Печать каждого дня в месяце
 * 1. Ввести с клавиатуры номер месяца текущего года
 * 2. Вывести на экран все его даты в формате d::MMM::uuuu
 */
public class Task_1 {
    public static void main(String[] args) {
        int month = getMonthNumber();
        printAllDatesInMonth(month);
    }

    private static void printAllDatesInMonth(int month) {
        int currentYear = LocalDate.now().getYear();

        try {
            int lengthOfMonth = LocalDate.of(currentYear, month, 1)
                    .lengthOfMonth();
            for (int day = 1; day < lengthOfMonth; day++) {
                LocalDate date = LocalDate.of(currentYear, month, day);
                System.out.println(date.format(DateTimeFormatter.ofPattern(
                        "d::MMM::uuuu", Locale.ENGLISH)));
            }
        } catch (DateTimeException e) {
            System.out.println("Incorrect month value: " + month);
        }
    }

    private static int getMonthNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month number: ");
        int month = 0;

        while (true) {
            try {
                String input = scanner.nextLine();
                month = Integer.parseInt(input);

                if (month > 12 || month < 1 ) {
                    System.out.print("The month number must be in the range" +
                            " from 1 to 12. Enter valid data: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Error while reading data. Enter an integer: ");
            }
        }

        return month;
    }
}