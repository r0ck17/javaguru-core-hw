package module5Exceptions.topic4FinalTask;

import java.io.File;

public class PhoneBookRunner {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBookImpl();

        phoneBook.addPerson("Ivan", "7 (900) 620-86-84");
        phoneBook.addPerson("Petr", "7 911 3417190");
        phoneBook.addPerson("Anastasia", "+7 911 341 71 90");
        phoneBook.addPerson("Nikolay", "24 69 10");

        File phoneBookFile = new File("phonebook.txt");
        phoneBookFile.deleteOnExit(); // опционально

        phoneBook.storeToFile(phoneBookFile);
        PhoneBook phoneBook2 = new PhoneBookImpl();
        phoneBook2.loadFromFile(phoneBookFile);

        System.out.println("Ivan".equals(phoneBook.getNameByNumber("7 (900) 620-86-84")));
        System.out.println("7 911 3417190".equals(phoneBook.getNumberByName("Petr")));
    }
}