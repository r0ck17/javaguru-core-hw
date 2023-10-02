package module4Collections.topic2Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Создайте класс Toy с полями: название игрушки, с какого возраста, цена
 *
 * Создайте HashMap, содержащий пары значений  - имя игрушки и объект игрушки (класс Toy).
 * Перебрать и распечатать пары значений - entrySet()
 * Перебрать и распечатать набор из имен продуктов  - keySet()
 * Перебрать и распечатать значения продуктов - values()
 */
public class Task_1 {
    public static void main(String[] args) {
        Map<String, Toy> toys = new HashMap<>() {{
            put("matryoshka", new Toy("matryoshka", 400, 6));
            put("constructor", new Toy("constructor", 800, 6));
            put("doll", new Toy("doll", 600, 3));
        }};

        for (Map.Entry<String, Toy> entry: toys.entrySet()) {
            System.out.printf("Name: %s. Toy: %s\n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nAll toy names:");
        for (String name: toys.keySet()) {
            System.out.println(name);
        }

        System.out.println("\nAll toys:");
        for (Toy toy: toys.values()) {
            System.out.println(toy);
        }

    }
}

class Toy {
    private String name;
    private int price;
    private int minimalAgeToPlay;

    public Toy(String name, int price, int minimalAgeToPlay) {
        this.name = name;
        this.price = price;
        this.minimalAgeToPlay = minimalAgeToPlay;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMinimalAgeToPlay() {
        return minimalAgeToPlay;
    }

    public void setMinimalAgeToPlay(int minimalAgeToPlay) {
        this.minimalAgeToPlay = minimalAgeToPlay;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", minimalAgeToPlay=" + minimalAgeToPlay +
                '}';
    }
}