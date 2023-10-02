package module8ReflectionSolid.Task_6_Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * Загрузите класс "java.util.LinkedList" или  "java.util.HashMap".
 * Выведите все поля класса, родительский класс, методы класса, конструкторы.
 * Выведите информацию о внутренних классах, если они есть.
 */
public class ReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<LinkedList> linkedListClass = LinkedList.class;
        printClassInfo(linkedListClass);
    }

    public static void printClassInfo(Class<?> clazz) {
        System.out.printf("Checking %s class%n%n", clazz.getName());

        Class<?> superclass = clazz.getSuperclass();
        System.out.println("Superclass: ");
        System.out.println(superclass.getName());

        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println("\nInterfaces: ");
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }


        System.out.println("\nDeclared constructors of the class:");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }

        System.out.println("\nDeclared methods of the class:");
        Method[] methods = clazz.getDeclaredMethods();
        Function<Method, String> annotations = method -> {
            Annotation[] list = method.getAnnotations();
            return list.length == 0 ? "" : Arrays.toString(list);
        };
        for (Method method : methods) {
            System.out.printf("%s %s%n", method, annotations.apply(method));
        }

        System.out.println("\nDeclared fields with annotations of the class:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.printf("%s%n", field);
        }

    }
}
