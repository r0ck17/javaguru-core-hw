package module1Basics.topic1DataTypes;

/**
 *     Написать код, который выведет значения переменных на экран:
 *
 *     byte b = 0х55;
 *     short s = 0x55ff;
 *     int i = 1000000;
 *     long l = 0xffffffffL;
 *     char с = 'a' ;
 *     float f = .25f;
 *     double d = .00001234;
 *     boolean bool = true;
 */
public class Task_1 {
    public static void main(String[] args) {
        byte b = 0x55;
        short s = 0x55ff;
        int i = 1000000;
        long l = 0xffffffffL;
        char c = 'a' ;
        float f = .25f;
        double d = .00001234;
        boolean bool = true;

        System.out.println("byte value\t\t = \t" + b);
        System.out.println("short value\t\t = \t" + s);
        System.out.println("int value\t\t = \t" + i);
        System.out.println("long value\t\t = \t" + l);
        System.out.println("char value\t\t = \t" + c);
        System.out.println("float value\t\t = \t" + f);
        System.out.println("double value\t = \t" + d);
        System.out.println("boolean value\t = \t" + bool);
    }
}
