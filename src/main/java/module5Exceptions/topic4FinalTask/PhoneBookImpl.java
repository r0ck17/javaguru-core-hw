package module5Exceptions.topic4FinalTask;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. Написать  реализацию интерфейса PhoneBook
 *      - Применить FileReader/BufferedReader/FileWriter/BufferedWriter.
 *      - В файле каждый пользователь на отдельной строке.
 *      - Разделитель имени и номера - запятая.
 *
 * 2. Организовать обработку исключений.
 *      - файл не найден
 *      - невозможно записать в файл
 *      - некорректный формат файла при чтении
 *      - имя не найдено
 *      - номер не найден
 *      - и все другие, которые посчитаете нужными
 *
 * 3. Будет плюсом
 *      - Написать класс PhoneBookTest с JUnit тестами для методов
 *      - addUser, getNumberByName, getNameByNumber, storeToFile, loadFromFile
 */
public class PhoneBookImpl implements PhoneBook {
    private Map<String, Person> persons;

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PhoneBookImpl() {
        persons = new HashMap<>();
    }

    @Override
    public void addPerson(String name, String number) {
        persons.put(number, new Person(name, number, LocalDate.now()));
    }

    @Override
    public String getNumberByName(String name) {
        for (Person person : persons.values()) {
            if (person.getName().equals(name)) {
                return person.getTelephone();
            }
        }
        return null;
    }

    @Override
    public String getNameByNumber(String number) {
        Person person = persons.get(number);
        return person != null ? person.getName() : null;
    }

    @Override
    public void storeToFile(File phoneBookFile) {
        phoneBookFile = phoneBookFile.getAbsoluteFile();
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(phoneBookFile))) {
            if (!phoneBookFile.exists()) {
                phoneBookFile.createNewFile();
            }
            for (Person person : persons.values()) {
                String line = String.format("%s, %s, %s\n",
                        person.getName(),
                        person.getTelephone(),
                        person.getCreatedDate().format(FORMATTER));
                writer.write(line);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Ошибка при записи в файл. Файл %s не найден\n",
                    phoneBookFile);
        } catch (IOException e) {
            System.out.printf("Ошибка при работе с файлом %s\n", phoneBookFile);
        }
    }

    @Override
    public void loadFromFile(File phoneBookFile) {
        phoneBookFile = phoneBookFile.getAbsoluteFile();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(phoneBookFile))) {
            String line = reader.readLine();
            while (line != null) {
                Person person = parsePersonFromString(line);
                if (person != null) {
                    persons.put(person.getTelephone(), person);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Ошибка. Файл %s не найден\n", phoneBookFile);
        } catch (IOException e) {
            System.out.printf("Ошибка при работе с файлом %s\n", phoneBookFile);
        }
    }

    private Person parsePersonFromString(String str) {
        Pattern pattern = Pattern.compile("[^,]+");
        Matcher matcher = pattern.matcher(str);
        String name = "";
        String number = "";
        String date = "";

        LocalDate createdAt;
        try {
            if (matcher.find()) {
                name = matcher.group(0).trim();
            }
            if (matcher.find()) {
                number = matcher.group(0).trim();
            }

            if (matcher.find()) {
                date = matcher.group(0).trim();
            }
            createdAt = LocalDate.parse(date, FORMATTER);

            if (isNotEmptyStrings(name, number, date)) {
                return new Person(name, number, createdAt);
            }
        } catch (DateTimeParseException e) {
            System.out.printf("Ошибка при считывании записи из файла. " +
                    "Нераспознанная запись: '%s'\n", str);
        }
        return null;
    }

    private static boolean isNotEmptyStrings(String... lines) {
        for (String line : lines) {
            if (line == null || line.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}

