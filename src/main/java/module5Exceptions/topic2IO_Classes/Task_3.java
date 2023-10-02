package module5Exceptions.topic2IO_Classes;

import java.io.*;
import java.util.Random;

/**
 * 1. Программно создать цепочку из трех папок.
 * 2. В конечном каталоге создать 5 произвольных текстовых файлов.
 * 3. Заполнить их 10 произвольными целыми числами.
 * 4. Содержимое файлов записать в один файл в том же каталоге.
 * 5. Создать файл, который будет содержать список файлов данного каталога.
 */
public class Task_3 {
    private static final String ROOT_PATH = "dir1\\dir2\\dir3\\";
    private static final String FILE_NAME_FORMAT = ROOT_PATH + "file_%d.txt";
    private static final int FILES_TO_CREATE_COUNT = 5;
    private static final int NUMBERS_IN_FILE_COUNT = 10;

    public static void main(String[] args) {
        createRootDirectories();
        createFilesWithContent();
        String content = readAllFilesContents();
        writeContentToFile(content, "result.txt");

        System.out.println(content);
    }

    private static void createRootDirectories() {
        File dirs = new File(ROOT_PATH).getAbsoluteFile();
        dirs.mkdirs();
    }

    private static void createFilesWithContent() {
        for (int i = 1; i <= FILES_TO_CREATE_COUNT; i++) {
            String filePath = String.format(FILE_NAME_FORMAT, i);
            try {
                createFileWithContent(filePath);
            } catch (IOException e) {
                System.out.printf("Error while creating file: %s\n", filePath);
            }
        }
    }

    private static void createFileWithContent(String filePath) throws IOException {
        File file = new File(filePath).getAbsoluteFile();
        file.createNewFile();
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < NUMBERS_IN_FILE_COUNT; i++) {
                int num = random.nextInt(100);
                writer.println(num);
            }
        }
    }

    private static String readAllFilesContents() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= NUMBERS_IN_FILE_COUNT; i++) {
            File file = new File(String.format(FILE_NAME_FORMAT, i));
            if (file.exists()) {
                sb.append(file.getName());
                sb.append("\n");
                String fileContent = getFileContent(file);
                sb.append(fileContent);
            }
        }
        return sb.toString();
    }

    private static String getFileContent(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String fileContent = bufferedReader.readLine();
            while (fileContent != null) {
                sb.append(fileContent);
                sb.append("\n");
                fileContent = bufferedReader.readLine();
            }
            sb.append("\n");
        } catch (IOException e) {
            System.out.printf("Error reading file content: %s", file.getName());
        }
        return sb.toString();
    }

    private static void writeContentToFile(String content, String fileName){
        try {
            File file = new File(ROOT_PATH + fileName).getAbsoluteFile();
            file.createNewFile();
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                bufferedWriter.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}