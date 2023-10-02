package module5Exceptions.topic1Exceptions;

/**
 * 1. Создать класс Division с методом public Double divide(String… arguments)
 * 2. в arguments значения должны приводиться к целочисленному типу, затем надо делить первое на второе, полученный результат делим на третье число и т.д.
 * 3. Обработать все возможные Exception в методе и по каждому вывести сообщение об ошибке.
 * 4. Добавить тестирующий класс с вызовом divide() и получить каждый вид Exception
 */
public class Task_4 {
    public static void main(String[] args) {
        System.out.println("(\"17\", \"3\", \"2\")");
        Double divide = Division.divide("17", "3", "2");
        System.out.println("method result: " + divide);

        System.out.println("\n(\"50\", \"2\", \"2\")");
        Double divide2 = Division.divide("50", "2", "2");
        System.out.println("method result: " + divide2);

        System.out.println("\n(\"27\", \"2\", \"5\")");
        Double divide3 = Division.divide("27", "2", "5");
        System.out.println("method result: " + divide3);

        System.out.println("\n(\"27\", \"X\", \"5\")");
        Double divide4 = Division.divide("27", "X", "5");
        System.out.println("method result: " + divide4);

        System.out.println("\nArray is null:");
        String[] test = null;
        Double divide5 = Division.divide(test);
        System.out.println("method result: " + divide5);

        System.out.println("\nArray length = 0:");
        String[] test2 = new String[]{};
        Double divide6 = Division.divide(test2);
        System.out.println("method result: " + divide6);
    }
}

class Division {
    public static Double divide(String... arguments) {
        if (arguments == null) {
            System.out.println("Передана null ссылка на массив");
            return null;
        }

        if (arguments.length == 0) {
            System.out.println("Размер массива должен больше 1");
            return null;
        }

        double result;

        try {
            result = Integer.parseInt(arguments[0]);
            int index = 1;
            while (index < arguments.length) {
                int num = Integer.parseInt(arguments[index]);
                result = (int) ((double) result / num);
                index++;
            }
        } catch (NumberFormatException e) {
            System.out.println("Массив должен состоять только из целых чисел");
            return null;
        }

        return result;
    }
}