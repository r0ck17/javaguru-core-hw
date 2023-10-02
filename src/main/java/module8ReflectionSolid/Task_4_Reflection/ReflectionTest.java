package module8ReflectionSolid.Task_4_Reflection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;

/**
 * Создать класс Man c произвольным набором полей и методов (не менее 3).
 *
 * Создать метод, который распечатает информацию о классе с помощью рефлексии.
 *
 * Вызвать метод с помощью рефлексии из основной программы.
 */
public class ReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Man> manClass = Man.class;
        printClassInfo(manClass);

        Method privateMethod = manClass.getDeclaredMethod("veryPrivateMethod", int.class);
        privateMethod.setAccessible(true);
        privateMethod.invoke(manClass, 10);
    }

    public static void printClassInfo(Class<?> clazz) {
        System.out.printf("Checking %s class%n%n", clazz.getName());

        Class<?> superclass = clazz.getSuperclass();
        System.out.println("Superclass: ");
        System.out.println(superclass.getName());

        System.out.println("\nDeclared constructors of the class:");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
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

@Data
@AllArgsConstructor
class Man extends Human {
    private int age;
    private String name;
    private String surname;

    Man (int age) {
        this.age = age;
    }

    @Deprecated
    private static void veryPrivateMethod(int secretKey) {
        System.out.println("how did you do this?");
    }
}

class Human {

}