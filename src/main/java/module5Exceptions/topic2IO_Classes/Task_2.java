package module5Exceptions.topic2IO_Classes;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. Создать файл с текстом.
 * 2. Прочитать файл.
 * 3. Подсчитать в тексте количество знаков препинания и слов.
 * 4. Вывести результат на экран.
 */
public class Task_2 {
    public static void main(String[] args) throws IOException {
        final String fileName = "test.txt";
        File file = createFile(fileName);
        System.out.printf("Path to file: %s\n", file.getPath());

        String fileContent = getContentFromFile(file);
        System.out.printf("File content: %s\n", fileContent);

        System.out.printf("Count of punctuation marks: %d\n",
                countPunctuationMarks(fileContent));
    }

    public static int countPunctuationMarks(String str) {
        Pattern compile = Pattern.compile("[.,;:!?\\-()\"]");
        Matcher matcher = compile.matcher(str);

        int countMatches = 0;
        while (matcher.find()) {
            countMatches++;
        }

        return countMatches;
    }

    private static String getContentFromFile(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(file))) {
            String res = bufferedReader.readLine();

            while (res != null) {
                sb.append(res);
                res = bufferedReader.readLine();
            }
        }
        return sb.toString();
    }

    private static File createFile(String name) throws IOException {
        File file = new File(name).getAbsoluteFile();
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(file))) {
            String line = "Hello, world!\nAny questions?\n(One more time)";
            bufferedWriter.write(line);
        }

        return file;
    }
}