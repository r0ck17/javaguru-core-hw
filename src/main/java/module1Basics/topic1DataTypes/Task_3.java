package module1Basics.topic1DataTypes;

/**
 * Написать метод, который принимает на вход значение промежутка времени в секундах.
 * Метод выводит на экран этот промежуток времени в виде часов минут и секунд, суток и недель.
 */
public class Task_3 {
    public static void main(String[] args) {
        int seconds = 604800 + 86400 * 8 + 3600 * 3 + 60 * 5 + 1;
        printTimeInterval(seconds);
    }

    public static void printTimeInterval(int totalSeconds) {
        int secondsInMinute = 60;
        int secondsInHour = secondsInMinute * 60;
        int secondsInDay = secondsInHour * 24;
        int secondsInWeek = secondsInDay * 7;

        int weeks = totalSeconds / secondsInWeek;
        totalSeconds %= secondsInWeek;

        int days = totalSeconds / secondsInDay;
        totalSeconds %= secondsInDay;

        int hours = totalSeconds / secondsInHour;
        totalSeconds %= secondsInHour;

        int minutes = totalSeconds / secondsInMinute;
        totalSeconds %= secondsInMinute;

        int seconds = totalSeconds % 60;

        System.out.println("weeks: " + weeks);
        System.out.println("days: " + days);
        String time = String.format("%s h, %s min, %s sec", hours, minutes, seconds);
        System.out.println("time: " + time);
    }
}
