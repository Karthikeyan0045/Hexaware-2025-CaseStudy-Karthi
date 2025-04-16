package com.petpals.main;

import com.petpals.exception.*;

import java.io.*;

public class FileReadDemo {
    public static void main(String[] args) {
        File file = new File("non_existing_file.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
