package module5Exceptions.topic1Exceptions;

/**
 * 1. Написать собственное исключение от Exception.
 * 2. Написать код, который будет выбрасывать его и обрабатывать.
 * 3. Результат работы программы вывести на экран.
 */
public class Task_2 {
    public static void main(String[] args) {
        try {
            System.out.println("Программа зашла в блок try");
            throw new MyException("Сообщение из собственного исключения");
        } catch (Exception e) {
            System.out.println("Программа зашла в блок catch");
            System.out.println(e);
        }
    }
}

class MyException extends Exception{
    public MyException(String msg) {
        super(msg);
    }
}