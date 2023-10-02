package module8ReflectionSolid.Task_2_Bulder;

import java.time.LocalDate;

/**
 * Создайте класс Person с полями: имя, фамилия, год рождения, адрес. Реализуйте у этого класса паттерн Строитель.
 * Введите поля с клавиатуры и заполните объект класса Person с помощью паттерна Строитель.
 */
public class AppRunner {
    public static void main(String[] args) {
        Person person = Person.newBuilder()
                .setAddress("Moscow")
                .setName("Ivan")
                .setSurname("Ivanov")
                .setBirthday(LocalDate.of(1990, 1, 1))
                .build();

        System.out.println(person);
    }
}