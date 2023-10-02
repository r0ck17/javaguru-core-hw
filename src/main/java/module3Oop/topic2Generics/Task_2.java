package module3Oop.topic2Generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Написать класс, который умеет хранить в себе массив любых типов данных (int, long etc.).
 *
 * Реализовать метод, который возвращает элемент массива по индексу и выводит его значение на экран.
 */
public class Task_2 {
    public static void main(String[] args) {
        arrayStorage<Integer> arrayStorage = new arrayStorage<>(10, Integer.class);

        arrayStorage.set(0, 4);
        arrayStorage.set(2, -4);
        arrayStorage.set(3, 5);
        arrayStorage.set(-1, -4);

        System.out.printf("\narray[i] = %d\n", arrayStorage.get(0));
        System.out.println(arrayStorage);
    }
}

class arrayStorage<T> {
    private final T[] array;

    public arrayStorage(int length, Class clazz) {
        //Как я понимаю это несколько костыльный способ, но используется разработчиками Java
        //this.array = (T[]) new Object[length];
        //Нашел другой способ, но так же кидает "uses unchecked or unsafe operations"
        array = (T[]) Array.newInstance(clazz, length);
    }

    public boolean set(int index, T newValue) {
        if (isCorrectIndex(index)) {
            array[index] = newValue;
            return true;
        }
        return false;
    }

    public T get(int index) {
        if (isCorrectIndex(index)) {
            return array[index];
        }
        return null;
    }

    private boolean isCorrectIndex(int index) {
        return index >= 0 && index < array.length - 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}