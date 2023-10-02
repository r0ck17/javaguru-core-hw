package module3Oop.topic4FactoryMethod;

public class House {
    private int temperatureCelsius;
    private int humidity;
    private static final int MIN_TEMPERATURE = -50;
    private static final int MAX_TEMPERATURE = 100;
    private static final int MIN_HUMIDITY = 0;
    private static final int MAX_HUMIDITY = 100;

    public House(int temperature, int humidity) {
        this.temperatureCelsius = getInitialTemperature(temperature);
        this.humidity = getInitialHumidity(humidity);
    }

    public int getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public int getHumidity() {
        return humidity;
    }

    public boolean setTemperatureCelsius(int value) {
        if (value <= MAX_TEMPERATURE && value >= MIN_TEMPERATURE) {
            this.temperatureCelsius = value;
            return true;
        }
        return false;
    }

    public boolean setHumidity(int value) {
        if (value <= MAX_HUMIDITY && value >= MIN_HUMIDITY) {
            this.humidity = value;
            return true;
        }
        return false;
    }

    public void printCurrentState() {
        System.out.printf("Температура: %d. Влажность: %d%n",
                temperatureCelsius, humidity);
    }

    private int getInitialTemperature(int temperature) {
        if (temperature > MAX_TEMPERATURE) {
            return MAX_TEMPERATURE;
        } else if (temperature < MIN_TEMPERATURE) {
            return MIN_TEMPERATURE;
        }
        return temperature;
    }

    private int getInitialHumidity(int humidity) {
        if (humidity > MAX_HUMIDITY) {
            return MAX_HUMIDITY;
        } else if (humidity < MIN_HUMIDITY) {
            return MIN_HUMIDITY;
        }
        return humidity;
    }
}