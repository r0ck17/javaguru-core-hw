package module2Classes.topic2Strings;

/**
 *
 * Напишите два цикла выполняющих 100 000 сложений строк вида “aaabbbccc”,
 * один с помощью оператора сложения и String, а другой с помощью StringBuilder
 * и метода append. Сравните скорость их выполнения. Выведите сравнение на экран.
 *
 */
public class Task_2 {
    public static void main(String[] args) {
        System.out.println("OS: " + System.getProperty("os.name", "Не определено"));
        System.out.println("OS architecture: " + System.getProperty("os.arch", "Не определено"));
        System.out.println("Java version: : " + System.getProperty("java.version", "Не определено"));
        System.out.println("JVM implementation: : " + System.getProperty("java.vm.name", "Не определено"));
        System.out.println("JVM version: : " + System.getProperty("java.vm.version", "Не определено"));

        long baseConcatTime = concatStringsWithOperator();
        long builderConcatTime = concatStringsWithBuilder();

        System.out.println("\nВремя алгоритма с использованием оператора сложения: ");
        System.out.printf("%.2f ms", baseConcatTime / 1_000_000.0);

        System.out.println("\n\nВремя алгоритма с использованием объекта класса StringBuilder: ");
        System.out.printf("%.2f ms", builderConcatTime / 1_000_000.0);

        System.out.printf("\n\nАлгоритм на основе StringBuilder быстрее конкатенации в '%d' раз.\n", baseConcatTime / builderConcatTime);
    }

    public static long concatStringsWithOperator() {
        String str = "";
        long startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            str += "*";
        }

        return System.nanoTime() - startTime;
    }

    public static long concatStringsWithBuilder() {
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            stringBuilder.append("aaabbbccc");
        }

        return System.nanoTime() - startTime;
    }
}
