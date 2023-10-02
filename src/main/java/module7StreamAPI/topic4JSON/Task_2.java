package module7StreamAPI.topic4JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String content = Files.readString(Path.of("test2.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Colours colours = objectMapper.readValue(content, Colours.class);

        System.out.println("Введите число от 1 до 7:");
        int colourId = scanner.nextInt();
        ConsoleColours textColour;

        switch (colourId) {
            case 1:
                textColour = ConsoleColours.RED;
                break;
            case 2:
                textColour = ConsoleColours.GREEN;
                break;
            case 3:
                textColour = ConsoleColours.BLUE;
                break;
            case 4:
                textColour = ConsoleColours.CYAN;
                break;
            case 5:
                textColour = ConsoleColours.MAGENTA;
                break;
            case 6:
                textColour = ConsoleColours.YELLOW;
                break;
            case 7:
                textColour = ConsoleColours.BLACK;
                break;
            default:
                textColour = ConsoleColours.WHITE;
        }

        System.out.println(textColour + "Мой любимый цвет" + ConsoleColours.RESET);
    }
}

class Colours {
    private Colour[] colours;

    public Colour[] getColours() {
        return colours;
    }

    public void setColours(Colour[] colours) {
        this.colours = colours;
    }
}

class Colour {
    private String id;
    private String colour;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Colour{" +
                "id=" + id +
                ", colour='" + colour + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

enum ConsoleColours {
    RESET("\033[0m"),
    BLACK("\033[0;30m"),
    RED("\033[0;31m"),
    GREEN("\033[0;32m"),
    YELLOW("\033[0;33m"),
    BLUE("\033[0;34m"),
    MAGENTA("\033[0;35m"),
    CYAN("\033[0;36m"),
    WHITE("\033[0;37m");

    private final String code;

    ConsoleColours(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}