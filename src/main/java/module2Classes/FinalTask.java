package module2Classes;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;


/**
 * Классы и объекты. Массивы. Поезд.
 *
 * Создайте класс Поезд с полями:
 * - Пункт назначения
 * - Номер поезда
 * - Время отправления (можно String, лучше LocalTime)
 *
 * Создайте массив из пяти элементов типа Поезд и заполните его тестовыми данными.
 *
 * Реализуйте методы:
 * 1. Сортировать массив поездов по номеру поезда по возрастанию и по убыванию
 * 2. Печать информации о поезде, номер которого пришел как входной параметр в метод
 * 3. Сортировать массив по пункту назначения, а поезда с одинаковым пунктом назначения сортируются по времени отправления между собой
 */
public class FinalTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество поездов (2 или более): ");
        int trainsCount = scanner.nextInt();

        while (trainsCount < 2) {
            System.out.print("Число меньше 2. Повторите ввод : ");
            trainsCount = scanner.nextInt();
        }

        Train[] trains = getTrains(trainsCount);
        printTrainsDetails(trains);

        System.out.print("\nВведите номер поезда для поиска в системе: ");
        int trainID = scanner.nextInt();
        printTrainDetailsById(trains, trainID);

        sortTrainsByIdDesc(trains);
        System.out.println("\n\n*Сортировка всех поездов в системе по номеру" +
                " поезда (по убыванию)*");
        printTrainsDetails(trains);

        sortTrainsByIdAsc(trains);
        System.out.println("\n*Сортировка всех поездов в системе по номеру" +
                " поезда (по возрастанию)*");
        printTrainsDetails(trains);

        sortTrainsByDestinationAndTime(trains);
        System.out.println("\n*Сортировка всех поездов в системе по пункту" +
                " назначения и времени отправления*");
        printTrainsDetails(trains);
    }

    public static void printTrainsDetails(Train[] trains) {
        System.out.println("\nДанные о всех поездах в системе:");
        int dashCount = 39;
        System.out.println("-".repeat(dashCount));
        System.out.printf("| %-8s | %-18s | %-5s |%n", "№",
                "Destination", "Time");
        System.out.println("-".repeat(dashCount));

        for (Train train : trains) {
            System.out.printf("| %-6d | %-18s | %s |", train.getId(),
                    train.getDestination(), train.getDepartureTime());
            System.out.println();
        }
        System.out.println("-".repeat(dashCount));
    }

    public static void printTrainDetailsById(Train[] trains, int trainID) {
        for (Train train : trains) {
            if (train.getId() == trainID) {
                System.out.printf("%nДанные о поезде с номером %d:", trainID);
                System.out.printf("%nПункт назначения: %s, Время прибытия: %s",
                        train.getDestination(), train.getDepartureTime());
                return;
            }
        }
        System.out.printf("Поезд с номером '%d' не найден.", trainID);
    }

    public static void sortTrainsByIdAsc(Train[] trains) {
        sortTrainsById(trains, true);
    }

    public static void sortTrainsByIdDesc(Train[] trains) {
        sortTrainsById(trains, false);
    }

    public static void sortTrainsByDestinationAndTime(Train[] trains) {
        for (int i = 0; i < trains.length; i++) {
            int minIndex = i;
            Train min = trains[i];

            for (int j = i + 1; j < trains.length; j++) {
                String dest1 = min.getDestination();
                String dest2 = trains[j].getDestination();
                int compare = dest1.compareTo(dest2);

                if (compare > 0 || (compare == 0
                        && trains[j].getDepartureTime()
                        .isBefore(min.getDepartureTime()))) {
                    min = trains[j];
                    minIndex = j;
                }
            }
            Train temp = trains[i];
            trains[i] = trains[minIndex];
            trains[minIndex] = temp;
        }
    }

    private static void sortTrainsById(Train[] trains, boolean isAscending) {
        for (int i = 0; i < trains.length; i++) {
            Train minTrain = trains[i];
            int currentId = minTrain.getId();
            int currentIndex = i;
            for (int j = i + 1; j < trains.length; j++) {
                if (isAscending) {
                    if (trains[j].getId() < currentId) {
                        minTrain = trains[j];
                        currentId = trains[j].getId();
                        currentIndex = j;
                    }
                } else {
                    if (trains[j].getId() > currentId) {
                        minTrain = trains[j];
                        currentId = trains[j].getId();
                        currentIndex = j;
                    }
                }
            }
            Train temp = trains[i];
            trains[i] = minTrain;
            trains[currentIndex] = temp;
        }
    }

    private static Train generateRandomTrain(int trainID) {
        Random random = new Random();

        String[] destinations = {"Moscow", "Kazan", "Perm", "Omsk", "Samara",
                "Saint Petersburg"};
        String destination = destinations[random.nextInt(destinations.length)];

        int hour = random.nextInt(24);
        int minute = random.nextInt(60);

        return new Train(trainID, destination, LocalTime.of(hour, minute));
    }

    private static Train[] getTrains(int trainsCount) {
        Train[] trains = new Train[trainsCount];

        int[] trainNumbers = generateTrainNumbers(trainsCount);

        for (int i = 0; i < trainsCount; i++) {
            trains[i] = generateRandomTrain(trainNumbers[i]);
        }

        return trains;
    }

    private static int[] generateTrainNumbers(int trainsCount) {
        Random random = new Random();

        int[] trainNumbers = new int[trainsCount];
        trainNumbers[0] = random.nextInt(50) + 100;

        for (int i = 1; i < trainNumbers.length; i++) {
            trainNumbers[i] = trainNumbers[i - 1] + random.nextInt(100);
        }
        return trainNumbers;
    }
}

class Train {
    private final int id;
    private final String destination;
    private LocalTime departureTime;

    public Train(int id, String destination, LocalTime departureTime) {
        this.id = id;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }
}