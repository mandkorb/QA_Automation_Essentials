package com.basics.demo;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class FileDemo {
    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public static void writeToFileWithFileWriter(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static void writeStringToFileWithBufferWriter(File file, String str, boolean append) throws IOException {
        FileWriter fileWriter = new FileWriter(file, append);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Character ch : str.toCharArray()) {
            bufferedWriter.append(ch);
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void writeStringToFileWithFileUtils(File file, String str, boolean append) throws IOException {
        FileUtils.writeStringToFile(file, str, StandardCharsets.UTF_8, append);
    }

    public static void readFromFileWithScanner(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        System.out.println("Reading from file:");
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void readFromFileWithFileUtils(File file) throws IOException {
        System.out.println(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
    }

    public static void readFromFileWithFiles(File file) throws IOException {
        System.out.println(Files.readAllLines(file.toPath()));
    }

    public static void readFromFileWithBufferReader(File file) throws IOException {
        // When you need to read file by chars
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        int ch;

        while ((ch = bufferedReader.read()) != -1) {
            stringBuffer.append((char) ch);
        }
        System.out.println(stringBuffer);
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void fillingCSVFileWithFakeData(File file, int rowsOfData) throws IOException {
        file.delete();
        Faker faker = new Faker();

        for (int i = 1; i <= rowsOfData; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            Integer age = faker.number().numberBetween(25, 65);

            String str = String.join(",", Integer.toString(i), firstName, lastName, age + "\n");
            FileUtils.writeStringToFile(file, str, StandardCharsets.UTF_8, true);
        }
    }

    public static void readCSVFile(File file) throws IOException {
        List<String> list = FileUtils.readLines(file, StandardCharsets.UTF_8);
        list.forEach(System.out::println);

    }

    private static Map<Integer, String> extractDataFromFile(File file) throws IOException {
        List<String> list = FileUtils.readLines(file, StandardCharsets.UTF_8);
        Map<Integer, String> map = new HashMap<>();
        for (String line : list) {
            String[] str = line.split(",");
            map.put(Integer.valueOf(str[0]), str[1]);
        }
        return map;
    }

    public static Map<Integer, Map<String, Object>> parseCSVFile(File file) throws IOException {
        List<String> usersList = FileUtils.readLines(file, StandardCharsets.UTF_8);
        Map<Integer, Map<String, Object>> users = new HashMap<>();

        for (String userInfo : usersList){
            String[] split = userInfo.split(",");
            Integer id = Integer.parseInt(split[0]);
            String firstName = split[1].trim();
            String lastName = split[2].trim();
            Integer age = Integer.parseInt(split[3]);

            Map<String, Object> user = new HashMap<>();
            user.put("firstName", firstName);
            user.put("lastname", lastName);
            user.put("age", age);

            users.put(id, user);
        }

        return users;
    }

    private static void printUsersList(Map<Integer, Map<String, Object>> users) {
        for (Map.Entry<Integer, Map<String, Object>> entry : users.entrySet()) {
            System.out.print("ID: " + entry.getKey() + "\n");
            for (Map.Entry<String, Object> entry1 : entry.getValue().entrySet()){
                System.out.println(entry1.getKey() + ": " + entry1.getValue());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
//        String fileName = "demoFile.txt";
//
//        createFile(fileName);
//        writeToFileWithFileWriter(fileName, "Hello, this is a demo file!");
//        readFromFileWithScanner(fileName);
//        deleteFile(fileName);

        File file = new File("test.csv");
//        String defaultStringToBeWritten = "Hello, World!";
//        String stringToBeWritten = " + New text";
//        boolean isTextAppendedToExisting = true;
//        writeStringToFileWithFileUtils(file, defaultStringToBeWritten, false);
//
//        System.out.print("\n\nRead file with File Utils: ");
//        readFromFileWithFileUtils(file);
//
//        System.out.print("Read file with Files: ");
//        readFromFileWithFiles(file);
//
//        System.out.print("Write file with BufferedReader with appending:" + stringToBeWritten);
//        writeStringToFileWithBufferWriter(file, stringToBeWritten, isTextAppendedToExisting);
//
//        System.out.print("\nRead file with BufferedReader: ");
//        readFromFileWithBufferReader(file);

        System.out.println("\n\nTesting more functions");
        System.out.println("Filling file with fake info.");
        fillingCSVFileWithFakeData(file, 10);

        System.out.println("Printing:");
        readCSVFile(file);
        Map<Integer, Map<String, Object>> users = parseCSVFile(file);
        printUsersList(users);


    }

}

