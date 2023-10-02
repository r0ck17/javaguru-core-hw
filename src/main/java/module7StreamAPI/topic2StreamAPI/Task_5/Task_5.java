package module7StreamAPI.topic2StreamAPI.Task_5;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Task_5 {
    private static final int PERSONS_COUNT = 100;

    public static void main(String[] args) {
        List<Person> persons = getPersons();
        System.out.println(persons);

        List<String> filtredPersons = persons.stream()
                .filter(p -> p.getAge() < 21)
                .peek(System.out::println)
                .sorted(Comparator.comparing(Person::getSurname)
                        .thenComparing(Person::getSurname))
                .limit(4)
                .map(p -> p.getSurname() + " " + p.getName()) // Не по ТЗ для наглядности
                .toList();

        System.out.println("\nfinal result: " + filtredPersons);
    }

    private static List<Person> getPersons() {
        String[] names = {"Ivan", "Evgeniy", "Dmitriy", "Petr", "Nikolay",
                "Maxim", "Sergey", "Andrey", "Konstantin"};
        String[] surnames = {"Petrov", "Smirnov", "Popov", "Kozlov", "Volkov",
                "Safonov", "Lazarev", "Sidorov", "Rybakov", "Kotov", "Titiov"};

        Random random = new Random();
        Supplier<Person> personGenerator = () -> {
            int nameIndex = random.nextInt(names.length);
            int surnameIndex = random.nextInt(surnames.length);
            int age = random.nextInt(12, 80);

            return new Person(names[nameIndex], surnames[surnameIndex], age);
        };

        return Stream.generate(personGenerator)
                .limit(PERSONS_COUNT)
                .toList();
    }
}


