package module1Basics.topic2ConditionStatements;

import java.util.Scanner;

/**
 * Написать метод, который выводит расписание на неделю.
 * Задать на вход в метод порядковый номер дня недели и отобразить на экране то,
 * что запланировано на этот день.
 */
public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayOfWeek = scanner.nextInt();
        displayScheduleByDayNumber(dayOfWeek);
    }

    public static void displayScheduleByDayNumber(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1:
                System.out.println("Планы на понедельник:");
                System.out.println("1. Ближе к вечеру встретиться с сестрой");
                break;
            case 2:
                System.out.println("Планы на вторник:");
                System.out.println("Записей пока нет");
                break;
            case 3:
                System.out.println("Планы на среду:");
                System.out.println("1. Вечерний поход в кино в 19:00");
                break;
            case 4:
                System.out.println("Планы на четверг:");
                System.out.println("1. Съездить к стоматологу в 18:00");
                break;
            case 5:
                System.out.println("Планы на пятницу:");
                System.out.println("1. Съездить в ленту и закупить все необходимое для дачи");
                break;
            case 6:
                System.out.println("Планы на субботу:");
                System.out.println("1. Поехать на дачу");
                System.out.println("2. Починить электрику");
                System.out.println("3. Продолжить высаживать саженцы деревьев");
                break;
            case 7:
                System.out.println("Планы на воскресенье:");
                System.out.println("1. Закончить с посадками деревьев");
                System.out.println("2. Починить крышу");
                System.out.println("2. Вернуться обратно");
                break;
            default:
                System.out.println("Порядковый номер дня недели введен неверно.");
        }
    }
}
