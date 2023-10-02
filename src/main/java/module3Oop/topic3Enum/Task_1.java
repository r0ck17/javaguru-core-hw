package module3Oop.topic3Enum;

/**
 * 1) Создать enum, который описывает сезоны года.
 *
 * Добавить поле description в этот enum.
 * Добавить поле countOfDays в этот enum.
 * Вывести на экран все константы сезоны года.
 *
 * 2) Написать метод, который выводит следующий сезон от заданного во входном параметре.
 * Входной параметр ввести с клавиатуры.
 */

public class Task_1 {
    public static void main(String[] args) {
        SeasonYear[] seasons = SeasonYear.values();

        System.out.println("Вывод всех сезонов года:\n");
        for (SeasonYear value : seasons) {
            System.out.printf("Сезон: %s, Описание: %s, количество дней: %d\n",
                    value, value.getDescription(), value.getCountOfDays());
        }

        System.out.println();
        for (SeasonYear value : seasons) {
            System.out.printf("После сезона %s следует %s\n", value.getDescription(),
                    getNextSeason(value).getDescription());
        }
    }

    public static SeasonYear getNextSeason(SeasonYear season) {
        SeasonYear[] seasons = SeasonYear.values();
        int nextSeasonIndex = (season.ordinal() + 1 ) % seasons.length;
        return seasons[nextSeasonIndex];
    }
}

enum SeasonYear {
    SPRING("Весна", 92), SUMMER("Лето", 92),
    AUTUMN("Осень", 91), WINTER("Зима", 90);
    private String description;
    private int countOfDays;

    SeasonYear(String description, int countOfDays) {
        this.description = description;
        this.countOfDays = countOfDays;
    }

    public String getDescription() {
        return description;
    }

    public int getCountOfDays() {
        return countOfDays;
    }
}
