package module3Oop.topic4FactoryMethod;

public class Humidifier implements Executable {
    @Override
    public boolean execute(int value, House house) {
        if (value < 0) {
            return false;
        }
        int currentHumidity = house.getHumidity();
        return house.setHumidity(currentHumidity + value);
    }
}
