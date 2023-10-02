package module9Exam.Task_4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

public class PlayerReaderTask implements Callable<List<Player>> {
    private final File contentFile;

    public PlayerReaderTask(File file) {
        this.contentFile = file;
    }

    @Override
    public List<Player> call() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Player> players = objectMapper.readValue(
                contentFile,
                new TypeReference<List<Player>>() {});

        return players.stream()
                .filter(p -> p.getAge() >= 25 && p.getAge() <= 30)
                .toList();
    }
}
