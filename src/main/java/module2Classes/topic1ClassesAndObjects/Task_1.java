package module2Classes.topic1ClassesAndObjects;

/**
 * Создайте класс Phone, который содержит поля number, model и weight
 *
 * ○ Создайте три объекта (экземпляра) этого класса.
 *
 * ○ Выведите в консоль значения полей объектов.
 *
 * ○ Добавьте в класс Phone методы:
 *  - receiveCall (один параметр – имя звонящего). Выводит на консоль сообщение “Звонит {name}”.
 *  - getNumber – возвращает номер телефона. Вызвать эти методы для каждого из объектов
 *
 * ○ Добавить второй метод receiveCall, который принимает два параметра
 * - имя звонящего и номер телефона звонящего. Вызвать этот метод.
 *
 * ○ Создать метод sendMessage с входным параметром - массив номеров телефонов,
 * которым надо отправить сообщение. Метод выводит на консоль номера этих телефонов.
 */
public class Task_1 {
    public static void main(String[] args) {
        Phone xiaomi = new Phone("89125648790", "Xiaomi A1", 240);
        Phone nokia = new Phone("89049851834", "Nokia 3310", 210);
        Phone onePlus = new Phone("89006209414", "OnePlus 7", 180);

        Phone[] mobiles = {xiaomi, nokia, onePlus};

        for (Phone mobile : mobiles) {
            System.out.println("Модель: \t" + mobile.getModel());
            System.out.println("Номер: \t\t" + mobile.getNumber());
            System.out.println("Вес: \t\t" + mobile.getWeight());

            mobile.receiveCall("Ivan");
            mobile.receiveCall("Max", "89117938491");

            System.out.println();
        }

        String[] numbers = {"89125648691", "89125813643"};
        onePlus.sendMessage(numbers);
    }
}

class Phone {
    private String number;
    private String model;
    private int weight;

    public Phone(String number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String callerName, String callerNumber) {
        System.out.println("Звонит " + callerName + " с номера " + callerNumber);
    }

    public void sendMessage(String[] numbers) {
        System.out.println("Ррассылку смс по номерам. "
                + "Количество номеров для отправки: " + numbers.length);
        for (String number : numbers) {
            System.out.println("Отправлено сообщение на номер " + number);
        }
    }
}