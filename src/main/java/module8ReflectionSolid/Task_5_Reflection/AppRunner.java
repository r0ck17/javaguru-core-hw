package module8ReflectionSolid.Task_5_Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Создайте класс с методом printHelloWorld(). Вызвать метод с помощью рефлексии из основной программы.
 */
public class AppRunner {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method printHelloWorld = ConsolePrinter.class.getDeclaredMethod("printHelloWorld");
        printHelloWorld.invoke(ConsolePrinter.class);
    }
}

class ConsolePrinter {
    public static void printHelloWorld() {
        System.out.println("Hello, World!");
    }
}
