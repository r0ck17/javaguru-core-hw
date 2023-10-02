package module2Classes.topic1ClassesAndObjects;

import java.util.Scanner;

/**
 * 1. Создать класс Clock (Часы)
 * 2. Задать поля alarmHours, alarmMinutes - время когда должен зазвонить будильник
 * 3. Создать метод для установки будильника public String setAlarm(int hours, int minutes)
 *      Метод проверяет на допустимость часы и минуты и в случае валидности устанавливает поля будильника.
 *
 * 4. Создать метод для проверки надо ли звонить сейчас public String checkAlarm(int hours, int minutes)
 *      если входные параметры hours и minutes совпадают с временем установленным в поля alarmHours, alarmMinutes, то метод возвращает “Chime” (звонок) либо “” (пустую строку) если будильник не сработал.
 *
 * 5. Часы должны звонить в 00 минут столько раз сколько часов, а также каждые 15 минут. Написать метод public int checkTimeCount(int hours, int minutes).
 *      Метод возвращает число сколько раз надо часам пробить. Например:
 *      17:15 вернуть 1 (звонить 1 раз),
 *      17:00 вернуть 5 (звонить 5 раз),
 *      17:01 вернуть 0 (не надо звонить)
 *
 * 6. Создать экземпляр часов, сделать проверки методов setAlarm, checkAlarm и checkTimeCount
 */
public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clock clock = new Clock();
        System.out.print("Введите количество часов для установки будильника: ");
        int hours = scanner.nextInt();

        System.out.print("Введите количество минут для установки будильника: ");
        int minutes = scanner.nextInt();

        System.out.println("\n*Установка будильника*");
        System.out.println(clock.setAlarm(hours, minutes));

        System.out.print("\nВведите количество часов для проверки заведенного будильника: ");
        int alarmHours = scanner.nextInt();

        System.out.print("Введите количество минут для проверки заведенного будильника: ");
        int alarmMinutes = scanner.nextInt();

        String shouldAlarmNow = clock.checkAlarm(alarmHours, alarmMinutes);
        if (shouldAlarmNow.isEmpty()) {
            System.out.println("Сейчас звонить не надо, будильник заведен на другое время.\n");
        } else {
            System.out.println(shouldAlarmNow);
        }

        System.out.print("\nВведите количество часов для проверки количества звонков будильника: ");
        alarmHours = scanner.nextInt();

        System.out.print("Введите количество минут для проверки количества звонков будильника: ");
        alarmMinutes = scanner.nextInt();

        int alarmCounts = Clock.checkTimeCount(alarmHours, alarmMinutes);
        if (alarmCounts != -1) {
            System.out.printf("Количество звонков будильника будет: %s%n", + alarmCounts);
        } else {
            System.out.println("Ошибка во введенном времени.");
        }
    }
}

class Clock {
    private int alarmHours;
    private int alarmMinutes;

    public String setAlarm(int hours, int minutes) {
        if (!Clock.isCorrectTime(hours, minutes)) {
            return "*Ошибка во введенном времени. Будильник не установлен*";
        }
        this.alarmHours = hours;
        this.alarmMinutes = minutes;
        return "*Будильник установлен*";
    }

    public String checkAlarm(int hours, int minutes) {
        if (alarmHours == hours && alarmMinutes == minutes) {
            return "Chime";
        }
        return "";
    }

    public static int checkTimeCount(int hours, int minutes) {
        if (!Clock.isCorrectTime(hours, minutes)) {
            return -1;
        }
        if (minutes == 0) {
            return hours;
        }
        return minutes % 15 == 0 ? minutes / 15 : 0;
    }

    private static boolean isCorrectTime(int hours, int minutes) {
        return hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59;
    }
}
