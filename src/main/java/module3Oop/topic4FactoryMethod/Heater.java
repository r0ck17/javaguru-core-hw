package module3Oop.topic4FactoryMethod;

public class Heater implements Executable {
    @Override
    public boolean execute(int value, House house) {
        if (value < 0) {
            return false;
        }
        int currentTemperature = house.getTemperatureCelsius();
        return house.setTemperatureCelsius(currentTemperature + value);
    }
}
