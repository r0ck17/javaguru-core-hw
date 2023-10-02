package module3Oop.topic4FactoryMethod;

public final class HouseDeviceFactory {
    private HouseDeviceFactory() {};
    public static Executable createDevice(String device) {
        String normalizedDevice = device.toLowerCase().trim();
        switch (normalizedDevice) {
            case "heater":
                return new Heater();
            case "humidifier":
                return new Humidifier();
        }
        return new Heater();
    }
}
