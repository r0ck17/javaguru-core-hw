package module5Exceptions.topic2IO_Classes;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * 1. Создать объект Person c полями name, surname, age.
 * 2. Сгенерировать 10 объектов класса Person со случайными значениями полей.
 * 3. С помощью Java создать файл, в который запишется информация о этих людях.
 */
public class Task_4 {
    private static final int PERSONS_COUNT = 10;
    private static final String FILE_NAME = "students.bin";

    public static void main(String[] args) {
        Person[] persons = getUsers();

        System.out.println("Array before serialization to file:");
        System.out.println(Arrays.toString(persons));
        serializeArrayToFile(persons);

        System.out.println("\nArray from binary file:");
        Person[] ivan = deserializeArrayFromFile();
        System.out.println(Arrays.toString(ivan));
    }

    private static Person[] deserializeArrayFromFile() {
        Person[] students;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (Person[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    private static void serializeArrayToFile(Person[] persons) {
        try (ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(persons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Person[] getUsers() {
        Person[] persons = new Person[PERSONS_COUNT];
        String[] names = {"Ivan", "Petr", "Evgeniy", "Nikolay", "Dmitriy"};
        String[] surNames = {"Ivanov", "Smirnov", "Popov", "Sokolov", "Titov"};
        Random random = new Random();

        for (int i = 0; i < persons.length; i++) {
            String name = names[random.nextInt(names.length)];
            String surName = surNames[random.nextInt(surNames.length)];
            persons[i] = new Person(name, surName, random.nextInt(60) + 18);
        }

        return persons;
    }
}

class Person implements Serializable {
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}