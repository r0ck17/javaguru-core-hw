package module3Oop.topic3Enum;

import java.util.Arrays;

/**
 * Создать enum - FoodType (PORRIDGE, BREAD, SOUP, VEGETABLE, NUT, FRUIT,  DAIRY, FISH, GREENS, MEAT, UNKNOWN)
 *
 * - Создать базовый абстрактный класс Food и в нем абстрактный метод public FoodType getFoodType();
 * - Создать 2-3 класса наследника Food и реализовать методы get/set name, a также переопределить getFoodType для каждого.
 * - Создать отдельный класс с методом проверки boolean isVegetarian(Food[] foods) в метод передается набор ингредиентов, на выходе true если все они вегетарианские.
 */
public class Task_2 {
    public static void main(String[] args) {
        Meat beef = new Meat();
        beef.setName("Стейк из говядины");

        Fruit banana = new Fruit();
        banana.setName("Банан");

        Parsley parsley = new Parsley();
        parsley.setName("Петрушка");

        Food[] foods1 = {beef, banana};
        Food[] foods2 = {parsley, banana};

        System.out.printf("Набор из %s является вегитарианским: %b\n", Arrays.toString(foods1), isVegetarianFoods(foods1));
        System.out.printf("Набор из %s является вегитарианским: %b\n", Arrays.toString(foods2), isVegetarianFoods(foods2));

    }
    public static boolean isVegetarianFoods(Food[] foods) {
        for (Food food : foods) {
            if (!isVegetarianFood(food)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isVegetarianFood(Food food) {
        FoodType[] vegetarianFoodTypes = {
                FoodType.PORRIDGE, FoodType.BREAD, FoodType.VEGETABLE,
                FoodType.NUT, FoodType.FRUIT, FoodType.DAIRY, FoodType.GREENS};

        FoodType foodType = food.getFoodType();

        for (FoodType type: vegetarianFoodTypes) {
            if (type.equals(foodType)) {
                return true;
            }
        }

        return false;
    }
}

enum FoodType {
    PORRIDGE, BREAD, SOUP, VEGETABLE, NUT,
    FRUIT, DAIRY, FISH, GREENS, MEAT, UNKNOWN
}

abstract class Food {
    private String name;
    public abstract FoodType getFoodType();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}

class Meat extends Food {
    @Override
    public FoodType getFoodType() {
        return FoodType.MEAT;
    }
}

class Fruit extends Food {
    @Override
    public FoodType getFoodType() {
        return FoodType.FRUIT;
    }
}

class Parsley extends Food {
    @Override
    public FoodType getFoodType() {
        return FoodType.GREENS;
    }
}
