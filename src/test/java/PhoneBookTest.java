import module5Exceptions.topic4FinalTask.PhoneBook;
import module5Exceptions.topic4FinalTask.PhoneBookImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private static final Path pathToContent  = Path.of("src", "test",
            "resources", "stored_book.txt").toAbsolutePath();
    private static final String DELIMITER = ",";
    private PhoneBook phoneBook;

    @BeforeEach
    public void initBook() {
        phoneBook = new PhoneBookImpl();
    }

    @Test
    public void testGetPersonInfo() {
        String number = "7 (900) 620-86-84";
        String name = "Ivan";
        phoneBook.addPerson(name, number);

        String actualName = phoneBook.getNameByNumber(number);
        assertEquals(name, actualName);

        String actualNumber = phoneBook.getNumberByName(name);
        assertEquals(number, actualNumber);
    }

    @Test
    public void testStoreToFile() throws IOException {
        phoneBook.addPerson("Ivan", "7 (900) 620-86-84");
        phoneBook.addPerson("Nikolay", "24 69 10");

        File file = Path.of("src", "test", "resources", "persons.txt")
                .toAbsolutePath().toFile();

        file.deleteOnExit();
        phoneBook.storeToFile(file);

        List<String> expectedLines = Files.readAllLines(pathToContent);

        List<String> actualLines = Files.readAllLines(file.toPath());
        assertEquals(expectedLines, actualLines);
    }

    @Test
    public void testLoadFromFile() throws IOException {
        String name1 = "Ivan";
        String telephone1 = "+7 911 341 71 90";
        String name2 = "Anastasia";
        String telephone2 = "7 (900) 620-86-84";
        String date = "10/08/2023";

        String firstLine = name1 + DELIMITER + telephone1 + DELIMITER + date + "\n";
        String secondLine = name2 + DELIMITER + telephone2 + DELIMITER + date;

        Path path = Path.of("src", "test", "resources", "testPhoneBook.txt")
                .toAbsolutePath();

        Files.writeString(path, firstLine + secondLine);
        phoneBook.loadFromFile(path.toFile());

        assertEquals(name1, phoneBook.getNameByNumber(telephone1));
        assertEquals(telephone1, phoneBook.getNumberByName(name1));

        assertEquals(name2, phoneBook.getNameByNumber(telephone2));
        assertEquals(telephone2, phoneBook.getNumberByName(name2));

        Files.delete(path);
    }
}