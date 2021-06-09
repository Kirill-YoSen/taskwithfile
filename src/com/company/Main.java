package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static String DataForFile(int i, int n) {
        String str = "";
        if (i == n) {
            for (Integer j = 1; j <= n; j++) {
                str += Integer.toString(i);
            }
            str+="\n";
            return str;
        }

        for (Integer j = 1; j <= i; j++) {
            str += Integer.toString(i);
        }
        str += "\n";
        str+=DataForFile(i+1, n);
        for (Integer j = 1; j <= i; j++) {
            str += Integer.toString(i);
        }
        str +="\n";
        return str;
    }

    public static void main(String[] args) {
        System.out.print("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        File file = new File("Test.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File Created.");
            } else {
                System.out.println("File Exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.fillInStackTrace();
        }
        try {
            Path path = Paths.get("Test.txt");
            BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
            bufferedWriter.write(DataForFile(1, n));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


