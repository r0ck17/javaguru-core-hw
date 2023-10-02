package module3Oop.topic1OOP;

/**
 * Создать цепочку наследования (минимум 3 звена) классов, описывающих должностную структуру на заводе. Реализовать метод по начислению зарплаты.
 *
 * Структура должна иметь хотя бы три уровня.
 * К примеру можно сделать класс Worker с методом getSalary, который возвращает фиксированную зарплату
 * От класса Worker наследуется класс рабочих, у которых кроме фиксированной зарплаты есть еще премия, метод getSalary будем переопределять и в нем использовать родительский super.getSalary для получения фиксированной зарплаты и к ней добавлять премию.
 * Это для примера, в этой задаче у вас есть свобода творчества)
 */
public class Task_1 {
    public static void main(String[] args) {
        Employee worker = new Employee(50_000);
        System.out.printf("Worker начислили зарплату размером %d р.", worker.getSalary());

        Manager manager = new Manager(60_000, 15_000);
        System.out.printf("\nManager начислили зарплату размером %d р.", manager.getSalary());

        TopManagement topManagement = new TopManagement(80_000, 25_000, 0.2);
        System.out.printf("\nManagement начислили зарплату размером %d р.\n", topManagement.getSalary());
    }
}


class Employee {
    protected int baseSalary;

    public Employee(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getSalary() {
        return baseSalary;
    }
}

class Manager extends Employee {
    private int bonus;

    public Manager(int baseSalary, int bonus) {
        super(baseSalary);
        this.bonus = bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + bonus;
    }
}

class TopManagement extends Manager {
    private double percentageRevenue;

    public TopManagement(int baseSalary, int bonus, double percentageRevenue) {
        super(baseSalary, bonus);
        this.percentageRevenue = percentageRevenue;
    }

    public void setPercentageRevenue(double percentageRevenue) {
        this.percentageRevenue = percentageRevenue;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + (int) (percentageRevenue * Account.getTotalRevenues());
    }
}

class Account {
    private static int totalRevenues = 300_000;

    public static int getTotalRevenues() {
        return totalRevenues;
    }
}
