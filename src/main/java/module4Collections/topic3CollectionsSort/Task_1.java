package module4Collections.topic3CollectionsSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Создать класс Student, содержащий следующие характеристики – имя, группа, средняя оценка.
 *
 * Создать коллекцию, содержащую объекты класса Student.
 * Написать метод, который удаляет студентов со средним баллом <3.
 * Написать методы, возвращающие коллекцию студентов отсортированных по:
 *
 * - имени
 * - группе
 * - средней оценке
 * - сначала по группе, затем в рамках одной группы по средней оценке
 */
public class Task_1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>() {{
            add(new Student("Ivan", "IB-1", 4.3));
            add(new Student("Anastasia", "IB-1", 4.7));
            add(new Student("Sergey", "IS-1", 3.8));
            add(new Student("Nikolay", "IS-1", 2.5));
            add(new Student("Konstantin", "OP-1", 3.4));
            add(new Student("Aleksandr", "OP-1", 2.8));
        }};

        System.out.println("Все студенты в базе:");
        printStudents(students);

        System.out.println("\n*Сортировка студентов в базе по имени*");
        List<Student> studentsSortByName = sortByName(students);
        printStudents(studentsSortByName);

        System.out.println("\n*Сортировка студентов в базе по группе*");
        List<Student> studentsSortByGroup = sortByGroup(students);
        printStudents(studentsSortByGroup);

        System.out.println("\n*Сортировка студентов в базе по средней оценке*");
        List<Student> studentsSortByGrade = sortByAvgGrade(students);
        printStudents(studentsSortByGrade);

        System.out.println("\n*Сортировка студентов в базе по группе и средней оценке*");
        List<Student> studentsSortByGroupGrade = sortByGroupAndGrade(students);
        printStudents(studentsSortByGroupGrade);

        System.out.println("\n*Удаление студентов с баллом ниже 3*\n");
        deleteStudentsAvgGradeLessThan3(students);

        System.out.println("Все студенты в базе:");
        printStudents(students);
    }

    public static void deleteStudentsAvgGradeLessThan3(List<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            if (Double.compare(iterator.next().getAvgGrade(), 3.0) == -1) {
                iterator.remove();
            }
        }
    }

    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            String formattedLine = String.format("%10s %s %s", student.getName(), student.getGroup(), student.getAvgGrade());
            System.out.println(formattedLine);
        }
    }

    public static List<Student> sortByName(List<Student> students) {
        ArrayList<Student> sortedList = new ArrayList<>(students);
        sortedList.sort(new StudentNameComparator());
        return sortedList;
    }

    public static List<Student> sortByGroup(List<Student> students) {
        ArrayList<Student> sortedList = new ArrayList<>(students);
        sortedList.sort(new StudentGroupComparator());
        return sortedList;
    }

    public static List<Student> sortByAvgGrade(List<Student> students) {
        ArrayList<Student> sortedList = new ArrayList<>(students);
        sortedList.sort(new StudentAvgGradeComparator());
        return sortedList;
    }

    public static List<Student> sortByGroupAndGrade(List<Student> students) {
        ArrayList<Student> sortedList = new ArrayList<>(students);
        Comparator<Student> groupAvgGradeComp = new StudentGroupComparator().
                thenComparing(new StudentAvgGradeComparator());
        sortedList.sort(groupAvgGradeComp);
        return sortedList;
    }
}

class Student {
    private final String name;
    private String group;
    private double avgGrade;

    public Student(String name, String group, double avgGrade) {
        this.name = name;
        this.group = group;
        this.avgGrade = avgGrade;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}

class StudentAvgGradeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getAvgGrade(), o2.getAvgGrade());
    }
}

class StudentGroupComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGroup().compareTo(o2.getGroup());
    }
}

class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}