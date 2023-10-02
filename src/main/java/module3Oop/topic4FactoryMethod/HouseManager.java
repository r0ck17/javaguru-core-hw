package module3Oop.topic4FactoryMethod;

public class HouseManager {
    public static void main(String[] args) {
        House house = new House(26, 45);
        house.printCurrentState();

        Executable heater = HouseDeviceFactory.createDevice("heater");
        int temperatureDelta = 2;
        boolean isHeaterWorked = heater.execute(temperatureDelta, house);
        System.out.printf("Включаем нагреватель чтобы изменить температуру" +
                " на %d C.\nВыполнен ли результат: %b\n\n", temperatureDelta, isHeaterWorked);
        house.printCurrentState();

        int temperatureDelta2 = -3;
        boolean isHeaterWorked2 = heater.execute(temperatureDelta2, house);
        System.out.printf("Включаем нагреватель чтобы изменить температуру" +
                " на %d C.\nВыполнен ли результат: %b\n\n", temperatureDelta2, isHeaterWorked2);
        house.printCurrentState();

        Executable humidifier = HouseDeviceFactory.createDevice("humidifier");
        int humidityDelta = 12;
        boolean isHumidifierWorked = humidifier.execute(humidityDelta, house);
        System.out.printf("Включаем увлажнитель чтобы изменить влажность" +
                " на %d %%.\nВыполнен ли результат: %b\n\n", humidityDelta, isHumidifierWorked);
        house.printCurrentState();

        int humidityDelta2 = -5;
        boolean isHumidifierWorked2 = humidifier.execute(humidityDelta2, house);
        System.out.printf("Включаем увлажнитель чтобы изменить влажность" +
                " на %d %%.\nВыполнен ли результат: %b\n\n", humidityDelta2, isHumidifierWorked2);
        house.printCurrentState();
    }
}
