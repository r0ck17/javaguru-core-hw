package module5Exceptions.topic3WorkWithData;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

/**
 *              Поиск дня в прошлом
 *
 * 1. Ввести число dayNum с клавиатуры - количество дней
 * 2. Найти дату, которая была dayNum дней назад
 * 3. Вывести на экран дату для часового пояса в Ереване в формате: 11 января 2008 20:30
 */
public class Task_2 {
    private static final String DATE_FORMAT_PATTERN = "d MMMM YYYY HH:mm";

    public static void main(String[] args) {
        int dayNum = getPositiveNumber();
        ZoneId zoneYerevan = ZoneId.of("GMT+4");
        LocalDateTime dateDaysAgo = getDateDaysAgo(dayNum, zoneYerevan);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                DATE_FORMAT_PATTERN, new Locale("ru"));

        System.out.printf("Дата за %d дня от текущей даты по Ереванскому времени: %s\n", dayNum, dateDaysAgo.format(formatter));
    }

    private static LocalDateTime getDateDaysAgo(int dayNum, ZoneId zoneId) {
        return LocalDateTime.now(zoneId).minusDays(dayNum);
    }

    private static int getPositiveNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число (больше 0): ");
        int day = 0;

        while (true) {
            try {
                String input = scanner.nextLine();
                day = Integer.parseInt(input);

                if (day < 1) {
                    System.out.print("Введенное число больше быть больше 0. " +
                            "Введите целое число: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Ошибка считывания данных. Введите целое число: ");
            }
        }

        return day;
    }
}