package module4Collections.topic1Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
 *
 * Удалить неудовлетворительные оценки из списка.
 * Выведите на консоль коллекцию.
 * Найти самую высокую оценку с использованием итератора.
 * Выведите на консоль оценку.
 */

public class Task_1 {
    private static final int STUDENTS_COUNT = 5;
    private static final int MAX_MARK = 5;
    private static final int MIN_MARK = 2;
    private static final int UNSATISFACTORY_GRADE = 2;


    public static void main(String[] args) {
        ArrayList<Integer> studentMarks = new ArrayList<>(STUDENTS_COUNT);

        fillList(studentMarks);
        System.out.printf("Оценки студентов: %s\n", studentMarks);

        removeBadMarks(studentMarks);
        System.out.printf("Оценки студентов без неуд. оценок: %s\n", studentMarks);

        int maxMark = getMaxMark(studentMarks);
        System.out.printf("Максимальная оценка: %d\n", maxMark);
    }

    private static void fillList(List<Integer> studentMarks) {
        Random random = new Random();

        for (int i = 0; i < STUDENTS_COUNT; i++) {
            studentMarks.add(random.nextInt(MAX_MARK - MIN_MARK + 1) + MIN_MARK);
        }
    }

    private static void removeBadMarks(List<Integer> studentMarks) {
        Iterator<Integer> iterator = studentMarks.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() == UNSATISFACTORY_GRADE) {
                iterator.remove();
            }
        }
    }

    private static int getMaxMark(List<Integer> studentMarks) {
        if (studentMarks.size() == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        Iterator<Integer> iterator = studentMarks.iterator();

        while (iterator.hasNext()) {
            int next = iterator.next();
            max = Math.max(max, next);
        }

        return max;
    }
}
