package module3Oop.topic2Generics;

import java.util.Scanner;

/**
 * Создать классы Car и Motorcycle, которые наследуются от общего класса Vehicle.
 *
 * Создать поле name в классе Vehicle и проинициализировать его через конструктора.
 *
 * Создать generic класс Garage, который может хранить только объекты типа наследуемого от Vehicle.
 *
 * Создать 2 объекта класса Garage (все поля ввести с клавиатуры) и вывести на экран имя хранимого транспортного средства.
 */
public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите модель машины: ");
        String carModel = scanner.nextLine();

        Car bmw = new Car(carModel);
        Garage<Car> carGarage = new Garage<>();

        System.out.println("***Гараж для автомобилей***\n");
        System.out.printf("Хранимый транспорт в гараже: '%s'\n", carGarage.getVehicleName());

        boolean isParked = carGarage.parkVehicle(bmw);
        if (isParked) {
            System.out.printf("Машина %s припаркована в гараж.\n", bmw.getName());
        } else {
            System.out.printf("Машина %s не припаркована в гараж.\n", bmw.getName());
        }
        System.out.printf("Хранимый транспорт в гараже: '%s'\n", carGarage.getVehicleName());

        Car pickedUpVehicle = carGarage.pickUpVehicle();
        if (pickedUpVehicle != null) {
            System.out.printf("Забрали %s из гаража.\n", pickedUpVehicle.getName());
        } else {
            System.out.println("Машин в гараже нет.");
        }

        Car pickedUpVehicle2 = carGarage.pickUpVehicle();
        if (pickedUpVehicle2 != null) {
            System.out.printf("Забрали %s из гаража.", pickedUpVehicle2.getName());
        } else {
            System.out.println("Машин в гараже нет.\n");
        }

        System.out.print("Введите модель мотоцикла: ");
        String motorcycleModel = scanner.nextLine();
        Motorcycle motorcycle = new Motorcycle(motorcycleModel);
        Garage<Motorcycle> motorcycleGarage = new Garage<>();

        System.out.println("***Гараж для Мотоциклов***\n");
        System.out.printf("Хранимый транспорт в гараже: '%s'\n", motorcycleGarage.getVehicleName());
        boolean isParked2 = motorcycleGarage.parkVehicle(motorcycle);

        if (isParked2) {
            System.out.printf("Мотоцикл %s припаркован в гараж.\n", motorcycle.getName());
        } else {
            System.out.printf("Мотоцикл %s не припаркована в гараж.\n", motorcycle.getName());
        }

        Motorcycle pickedUpVehicle3 = motorcycleGarage.pickUpVehicle();
        if (pickedUpVehicle3 != null) {
            System.out.printf("Забрали %s из гаража.\n", pickedUpVehicle3.getName());
        } else {
            System.out.println("Машин в гараже нет.");
        }
    }
}

abstract class Vehicle {
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String name) {
        super(name);
    }
}

class Garage<T extends Vehicle> {
    private T vehicle;

    public boolean parkVehicle(T parkVehicle) {
        if (vehicle == null) {
            vehicle = parkVehicle;
            return true;
        }
        return false;
    }

    public T pickUpVehicle() {
        if (this.vehicle == null) {
            return null;
        }

        T pickUpVehicle = this.vehicle;
        this.vehicle = null;
        return pickUpVehicle;
    }

    public String getVehicleName() {
        return vehicle != null ? vehicle.getName() : "";
    }
}