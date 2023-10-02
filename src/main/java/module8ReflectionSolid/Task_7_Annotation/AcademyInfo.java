package module8ReflectionSolid.Task_7_Annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * Создать собственную аннотацию @AcademyInfo c полем year.
 * Создать метод, помеченный этой аннотацией с заданным year, и метод без нее.
 * С помощью рефлексии проверить наличие данной аннотации у этих методов из основной программы.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AcademyInfo {
    int year();
}

class Person {
    public void sayHello() {
        System.out.println("Hello");
    }

    @AcademyInfo(year = 2023)
    public void sayGoodbye() {
        System.out.println("Goodbye");
    }
}

class AnnotationTest {
    public static void main(String[] args) {
        printClassMethodsWithAnnotation(Person.class, AcademyInfo.class);
    }

    public static void printClassMethodsWithAnnotation(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        System.out.printf("Checking class '%s' for methods with '%s' annotation.%n",
                clazz.getSimpleName(),
                annotationClass.getSimpleName());
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(annotationClass)) {
                AcademyInfo annotation = (AcademyInfo) method.getAnnotation(annotationClass);
                System.out.printf("Method %s, value = %d", method.getName(), annotation.year());
            }
        }
    }
}