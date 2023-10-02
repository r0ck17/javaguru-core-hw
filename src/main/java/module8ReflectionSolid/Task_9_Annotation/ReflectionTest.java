package module8ReflectionSolid.Task_9_Annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
    public static void main(String[] args) {
        catLife();
    }

    public static void catLife() {
        Cat cat = catCreator();
        cat.eat();
        cat.sleep(3);
    }

    public static Cat catCreator() {
        try {
            Constructor<Cat> constructor = Cat.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

class Cat {
    public Cat() {
        System.out.println("Instance of class Cat is created.");
    }
    public void eat() {
        System.out.println("Cat is eating.");
    }

    public void sleep(int hours) {
        System.out.println("Cat now sleep for " + hours + " hours.");
    }
}