import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileSystemManager {

    private File currentDirectory;
    private Scanner scanner;
    private SimpleDateFormat dateFormat;
    public FileSystemManager() {
        currentDirectory = new File(System.getProperty("user.dir"));
        scanner = new Scanner(System.in);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    public void start() {
        System.out.println("Welcome to File System Manager!");

        boolean running = true;
        while (running) {
            System.out.print(currentDirectory.getAbsolutePath() + " > ");

            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                running = false;
            } else {
                running = processCommand(command);
            }
        }

        scanner.close();
    }

    private boolean processCommand(String command) {
        String[] parts = command.trim().split("\\s+", 2);
        String cmd = parts[0];
        String args = (parts.length > 1) ? parts[1] : "";

        switch (cmd) {
            case "help": displayHelp(); break;
            case "ls": listFiles(); break;
            case "cd": changeDirectory(args); break;
            case "pwd": System.out.println(currentDirectory.getAbsolutePath()); break;
            case "mkdir": createDirectory(args); break;
            case "touch": createFile(args); break;
            case "rm": delete(args); break;
            case "rename":
                String[] names = args.split("\\s+");
                if (names.length == 2) rename(names[0], names[1]);
                break;
            case "find": findFiles(args); break;
            case "info": displayFileInfo(args); break;
            default: System.out.println("Unknown command");
        }
        return true;
    }

    private void displayHelp() {
        System.out.println("Commands: ls, cd, pwd, mkdir, touch, rm, rename, find, info, exit");
    }
    private void listFiles() {
        File[] files = currentDirectory.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println((f.isDirectory() ? "d " : "- ") + f.getName());
            }
        }
    }
    private void changeDirectory(String dirName) {
        if (dirName.equals("..")) {
            currentDirectory = currentDirectory.getParentFile();
        } else {
            File newDir = new File(currentDirectory, dirName);
            if (newDir.exists() && newDir.isDirectory()) {
                currentDirectory = newDir;
            } else {
                System.out.println("Directory not found!");
            }
        }
    }
    private void createDirectory(String name) {
        File dir = new File(currentDirectory, name);
        if (dir.mkdir()) {
            System.out.println("Directory created!");
        } else {
            System.out.println("Failed!");
        }
    }
    private void createFile(String name) {
        try {
            File file = new File(currentDirectory, name);
            if (file.createNewFile()) {
                System.out.println("File created!");
            } else {
                System.out.println("Already exists!");
            }
        } catch (IOException e) {
            System.out.println("Error creating file!");
        }
    }
    private void delete(String name) {
        File file = new File(currentDirectory, name);
        if (file.exists()) {
            file.delete();
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }
    }
    private void rename(String oldName, String newName) {
        File oldFile = new File(currentDirectory, oldName);
        File newFile = new File(currentDirectory, newName);

        if (oldFile.renameTo(newFile)) {
            System.out.println("Renamed!");
        } else {
            System.out.println("Failed!");
        }
    }
    private void findFiles(String pattern) {
        searchRecursive(currentDirectory, pattern);
    }

    private void searchRecursive(File dir, String pattern) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.getName().contains(pattern)) {
                    System.out.println(f.getAbsolutePath());
                }
                if (f.isDirectory()) {
                    searchRecursive(f, pattern);
                }
            }
        }
    }
    private void displayFileInfo(String name) {
        File file = new File(currentDirectory, name);

        if (file.exists()) {
            System.out.println("Name: " + file.getName());
            System.out.println("Size: " + file.length());
            System.out.println("Directory: " + file.isDirectory());
            System.out.println("Last Modified: " +
                    dateFormat.format(new Date(file.lastModified())));
        } else {
            System.out.println("File not found!");
        }
    }

    public static void main(String[] args) {
        new FileSystemManager().start();
    }
}