package module5Exceptions.topic2IO_Classes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1. Вывести список файлов и каталогов выбранного каталога на диске.
 * 2. Файлы и каталоги должны быть распечатаны отдельно.
 */
public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dir = scanner.nextLine();
        printDirectoryContent(dir);
    }

    public static void printDirectoryContent(String path) {
        File dir = new File(path).getAbsoluteFile();

        if (!dir.exists()) {
            System.out.printf("Path '%s' not found.", dir);
            return;
        }
        if (!dir.isDirectory()) {
            System.out.printf("Path '%s' is not a directory.", dir);
            return;
        }

        List<File> files = getFilesList(dir);
        List<File> dirs = getDirectoriesList(dir);

        System.out.println("Absolute path to directory: " + dir);
        printAllFiles(files);
        printAllDirectories(dirs);
    }

    private static void printList(List<File> list) {
        for (File file : list) {
            System.out.printf("- %s\n", file.getName());
        }
    }

    private static List<File> getDirectoriesList(File dir) {
        List<File> dirs = new ArrayList<>();
        for (File file: dir.listFiles()) {
            if (file.isDirectory()) {
                dirs.add(file);
            }
        }
        return dirs;
    }

    private static List<File> getFilesList(File dir) {
        List<File> files = new ArrayList<>();
        for (File file: dir.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }

    private static void printAllFiles(List<File> files) {
        if (!files.isEmpty()) {
            System.out.println("\nFiles list:");
            printList(files);
        } else {
            System.out.println("\nNo files.");
        }
    }

    private static void printAllDirectories(List<File> files) {
        if (!files.isEmpty()) {
            System.out.println("\nDirectories list:");
            printList(files);
        } else {
            System.out.println("\nNo directories.");
        }
    }
}