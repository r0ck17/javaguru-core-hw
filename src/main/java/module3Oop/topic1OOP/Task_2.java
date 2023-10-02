package module3Oop.topic1OOP;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Реализовать иерархию цветов (розы, гвоздики, тюльпаны, лилии и... что-то на свой вкус).
 *
 * - Создать несколько объектов-цветов со свойствами:
 *     - стоимость
 *     - дата поступления
 *     - срок годности с даты поступления
 *     - цвет
 *
 * - Все поля сделайте private  и напишите для всех полей getter и setter методы
 * - Собрать букет и определить его стоимость. (Напишите метод для сбора букета)
 * - Определить все цвета, используемые в букете.
 * - Определить, когда весь букет завянет (Не обязательное)
 *
 * В букет может входить несколько цветов одного типа.
 */
public class Task_2 {
    public static void main(String[] args) {
        Flower[] flowers = getBouquetFlowers();

        printFlowers(flowers);

        int totalPrice = getBouquetPrice(flowers);
        System.out.println("\nОбщая стоимость букета: " + totalPrice);

        String[] flowersColours = getFlowersColours(flowers);
        System.out.println("\nВсе цвета, используемые в букете: ");
        System.out.println(Arrays.toString(flowersColours));

        LocalDate dayBouquetWither = getDayBouquetWither(flowers);
        System.out.println("\nДень когда завянет весь букет: " + dayBouquetWither);
    }

    public static int getBouquetPrice(Flower[] flowers) {
        int price = 0;
        for (Flower flower : flowers) {
            price += flower.getPrice();
        }
        return price;
    }

    public static String[] getFlowersColours(Flower[] flowers) {
        String[] tempColours = new String[flowers.length];
        int index = 0;
        boolean isRecorded;

        for (Flower flower : flowers) {
            isRecorded = false;
            for (int j = 0; j < index; j++) {
                if (flower.getColor().equals(tempColours[j])) {
                    isRecorded = true;
                    break;
                }
            }
            if (!isRecorded) {
                tempColours[index] = flower.getColor();
                index++;
            }
        }
        String[] colours = new String[index];
        System.arraycopy(tempColours, 0, colours, 0, index);
        return colours;
    }

    public static LocalDate getDayBouquetWither(Flower[] flowers) {
        if (flowers.length == 0) {
            return null;
        }
        LocalDate lastDayWither = getDayFlowerWither(flowers[0]);

        for (int i = 1; i < flowers.length; i++) {
            LocalDate dayFlowerWither = getDayFlowerWither(flowers[i]);
            if (dayFlowerWither.isAfter(lastDayWither)) {
                lastDayWither = dayFlowerWither;
            }
        }

        return lastDayWither;
    }

    private static void printFlowers(Flower[] flowers) {
        System.out.println("Все цветы в букете:");
        for (Flower flower : flowers) {
            System.out.printf("%s, привоз: %s, срок годности: %d, цвет: %s, цена: %d\n",
                    flower.getClass().getSimpleName(),
                    flower.getArrivalDate(),
                    flower.getDaysExpirationDate(),
                    flower.getColor(),
                    flower.getPrice());
        }
    }

    private static LocalDate getDayFlowerWither(Flower flower) {
        return flower.getArrivalDate().plusDays(flower.getDaysExpirationDate());
    }

    private static Flower[] getBouquetFlowers() {
        Chamomile chamomileRed = new Chamomile(240, LocalDate.of(2023, 7, 20),
                14, "Red");
        Chamomile chamomileWhite = new Chamomile(180, LocalDate.of(2023, 7, 22),
                14, "White");

        Rose rosePink = new Rose(200, LocalDate.of(2023, 7, 22), 20, "Pink");
        Chrysanthemum chrysanthemumPurple = new Chrysanthemum(250,
                LocalDate.of(2023, 7, 19), 14, "Purple");

        Gerbera gerberaPurple = new Gerbera(120,
                LocalDate.of(2023, 7, 19), 14, "Red");

        return new Flower[]{chamomileRed, chamomileWhite, rosePink, chrysanthemumPurple, gerberaPurple};
    }
}

abstract class Flower {
    private int price;
    private LocalDate arrivalDate;
    private int daysExpirationDate;
    private String color;

    public Flower(int price, LocalDate arrivalDate, int daysExpirationDate, String color) {
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.daysExpirationDate = daysExpirationDate;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getDaysExpirationDate() {
        return daysExpirationDate;
    }

    public void setDaysExpirationDate(int daysExpirationDate) {
        this.daysExpirationDate = daysExpirationDate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class Chamomile extends Flower {
    public Chamomile(int price, LocalDate arrivalDate, int daysExpirationDate, String color) {
        super(price, arrivalDate, daysExpirationDate, color);
    }
}

class Rose extends Flower {
    public Rose(int price, LocalDate arrivalDate, int daysExpirationDate, String color) {
        super(price, arrivalDate, daysExpirationDate, color);
    }
}

class Chrysanthemum extends Flower {
    public Chrysanthemum(int price, LocalDate arrivalDate, int daysExpirationDate, String color) {
        super(price, arrivalDate, daysExpirationDate, color);
    }
}

class Gerbera extends Flower {
    public Gerbera(int price, LocalDate arrivalDate, int daysExpirationDate, String color) {
        super(price, arrivalDate, daysExpirationDate, color);
    }
}