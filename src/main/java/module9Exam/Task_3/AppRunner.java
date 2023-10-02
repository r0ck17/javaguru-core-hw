package module9Exam.Task_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.random;

public class AppRunner {
    public static void main(String[] args) {
        List<Car> cars = getCars();

        Map<Integer, List<Car>> carsByEngineCapacity =
                cars.stream()
                        .collect(Collectors.groupingBy(Car::getEngineCapacity));

        List<String> lines = carsByEngineCapacity.entrySet()
                .stream()
                .map(entry -> {
                    List<Car> list = entry.getValue();
                    String line = list.stream()
                            .map(Car::toString)
                            .collect(Collectors.joining(", ", "[", "]"));
                    return entry.getKey() + ":" + line;
                })
                .toList();

        try {
            Files.write(Path.of("cars.txt"), lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Car> getCars() {
        Supplier<Car> carGenerator = () -> {
            String name = "carName" + ((int) (random() * 100));
            CarModel carModel = CarModel.values()[(int) (random() * 3)];
            int engine = (int) (random() * 3 + 1);
            return new Car(name, carModel, engine);
        };

        return Stream.generate(carGenerator)
                .limit(10)
                .toList();
    }
}

class Car {
    private final String name;
    private final CarModel carModel;
    private final int engineCapacity;

    public Car(String name, CarModel carModel, int engineCapacity) {
        this.name = name;
        this.carModel = carModel;
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", carModel=" + carModel +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}

enum CarModel {
    NISSAN, BMW, PORSCHE
}
