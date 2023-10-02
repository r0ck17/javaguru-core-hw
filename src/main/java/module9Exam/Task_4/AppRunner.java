package module9Exam.Task_4;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppRunner {
    private static final int THREADS_COUNT = 4;
    private static final int TASKS_COUNT = 10;

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(THREADS_COUNT);
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < TASKS_COUNT; i++) {
            Future<File> fileFuture = pool.submit(new PlayerGeneratorTask());
            File file = fileFuture.get();
            Future<List<Player>> listFuture = pool.submit(
                    new PlayerReaderTask(file));
            List<Player> playersFromFile = listFuture.get();
            players.addAll(playersFromFile);
        }

        players.stream()
                .sorted(Comparator.comparing(Player::getAge))
                .limit(5)
                .forEach(System.out::println);

        pool.shutdown();
    }
}
