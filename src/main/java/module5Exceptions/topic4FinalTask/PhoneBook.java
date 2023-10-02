package module5Exceptions.topic4FinalTask;

import java.io.File;

/**
 * Объявить данный интерфейс
 */
public interface PhoneBook {
    void addPerson(String name, String number);
    String getNumberByName(String name);
    String getNameByNumber(String number);
    void storeToFile(File phoneBookFile);
    void loadFromFile(File phoneBookFile);
}
