package module2Classes.topic1ClassesAndObjects;

import java.util.Scanner;

/**
 * Создать класс описывающий Банкомат.
 *
 * Набор купюр, находящихся в банкомате, должен задаваться свойствами: количеством купюр номиналом 20, 50, 100.
 * Сделать методы для добавления денег в банкомат.
 * Сделать метод, снимающий деньги.
 * С клавиатуры передается сумма денег. На экран выводим операция удалась или нет.
 * При снятии денег метод должен выводить на экран каким количеством купюр и какого номинала выдается сумма. Создать конструктор с тремя параметрами – количеством купюр разного наминала.
 */
public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество купюр номиналом 20 (целое число): ");
        int num20DollarBills = scanner.nextInt();
        System.out.print("Введите количество купюр номиналом 50 (целое число): ");
        int num50DollarBills = scanner.nextInt();
        System.out.print("Введите количество купюр номиналом 100 (целое число): ");
        int withdrawalAmount = scanner.nextInt();

        CashMachine cashMashine = new CashMachine(num20DollarBills, num50DollarBills, withdrawalAmount);
        cashMashine.printAllBillsCounts();

        System.out.print("\n[Пополнение] Введите количество купюр номиналом `20`: ");
        num20DollarBills = scanner.nextInt();
        cashMashine.add20dollarBills(num20DollarBills);

        System.out.print("[Пополнение] Введите количество купюр номиналом `50`: ");
        num50DollarBills = scanner.nextInt();
        cashMashine.add50dollarBills(num50DollarBills);

        System.out.print("[Пополнение] Введите количество купюр номиналом `100`: ");
        withdrawalAmount = scanner.nextInt();
        cashMashine.add100dollarBills(withdrawalAmount);

        cashMashine.printAllBillsCounts();

        System.out.print("\n[Снятие] Введите сумму для снятия: ");
        withdrawalAmount = scanner.nextInt();
        cashMashine.withdrawMoney(withdrawalAmount);

        cashMashine.printAllBillsCounts();
    }
}

class CashMachine {
    private int count20DollarBills;
    private int count50DollarBills;
    private int count100DollarBills;

    public CashMachine(int num20dollarBills, int num50dollarBills, int num100dollarBills) {
        this.count20DollarBills = num20dollarBills;
        this.count50DollarBills = num50dollarBills;
        this.count100DollarBills = num100dollarBills;
    }

    public void add20dollarBills(int num20dollarBills) {
        this.count20DollarBills += num20dollarBills;
    }

    public void add50dollarBills(int num50dollarBills) {
        this.count50DollarBills += num50dollarBills;
    }

    public void add100dollarBills(int num100dollarBills) {
        this.count100DollarBills += num100dollarBills;
    }

    public void withdrawMoney(int amount) {
        int totalAmount = count20DollarBills * 20 + count50DollarBills * 50 + count100DollarBills * 100;

        if (amount <= totalAmount) {
            int currNum100DollarBills = Math.min(amount / 100, this.count100DollarBills);
            amount -= currNum100DollarBills * 100;

            int currNum50DollarBills = Math.min(amount / 50, this.count50DollarBills);
            amount -= currNum50DollarBills * 50;

            int currNum20DollarBills = Math.min(amount / 20, this.count20DollarBills);
            amount -= currNum20DollarBills * 20;

            if (amount == 0) {
                this.count100DollarBills -= currNum100DollarBills;
                this.count50DollarBills -= currNum50DollarBills;
                this.count20DollarBills -= currNum20DollarBills;
                System.out.println("\n[Снятие] Операция успешна. Количество выданных купюр.:");
                System.out.println("Количество купюр номиналом [20]: " + currNum20DollarBills);
                System.out.println("Количество купюр номиналом [50]: " + currNum50DollarBills);
                System.out.println("Количество купюр номиналом [100]: " + currNum100DollarBills);
            } else {
                System.out.println("Данную сумму невозможно выдать. Введите другую сумму");
            }
        } else {
            System.out.println("Недостаточно средств. Введите другую сумму.");
        }
    }

    public void printAllBillsCounts() {
        System.out.println("\nОбщее количество купюр в банокмате:");
        System.out.println("Количество купюр номиналом [20]: " + count20DollarBills);
        System.out.println("Количество купюр номиналом [50]: " + count50DollarBills);
        System.out.println("Количество купюр номиналом [100]: " + count100DollarBills);
    }
}
