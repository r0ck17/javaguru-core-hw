package module9Exam.Task_4;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.lang.Math.random;
import static java.lang.String.format;

public class PlayerGeneratorTask implements Callable<File> {
    private final int PLAYERS_COUNT = 10;
    private static int GENERATED_FILES_COUNT = 0;

    @Override
    public File call() {
        List<Player> players = getPlayers();
        ObjectMapper objectMapper = new ObjectMapper();
        File resultFile;
        try {
            resultFile = new File(format("players%d.json", ++GENERATED_FILES_COUNT))
                    .getAbsoluteFile();
            objectMapper.writeValue(resultFile, players);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return resultFile;
    }

    private List<Player> getPlayers() {
        Supplier<Player> playerGenerator = () -> {
            String name = "name" + (int) (random() * 50);
            int age = 20 + (int) (random() * 21);
            boolean isActive = random() > 0.5;
            return new Player(name, age, isActive);
        };

        return Stream.generate(playerGenerator)
                .limit(PLAYERS_COUNT)
                .toList();
    }
}
