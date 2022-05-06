package com.danilovmaximov;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterNumbers {
    private static String outputFilename;

    private static void filterNumsAndOutput(List<Integer> source) {
        List<Integer> outputNumbers;
        if (source.size() % 2 == 0) {
            outputNumbers = source.stream()
                    .filter(num -> num % 2 == 0)
                    .collect(Collectors.toList());
        } else {
            outputNumbers = source.stream()
                    .filter(num -> num % 2 != 0)
                    .collect(Collectors.toList());
        }

        if (outputFilename != null) {
            try {
                File outputFile = new File(outputFilename);
                // If file does not exist, create it
                if (outputFile.getParentFile() != null) {
                    outputFile.getParentFile().mkdirs();
                }
                outputFile.createNewFile();
                FileWriter output = new FileWriter(outputFile);
                output.write(outputNumbers.toString());
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(outputNumbers);
        }
    }

    private static void getNumsFromConsole(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Amount of numbers must be a positive integer.");
        }
        List<Integer> inputNumbers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < amount; i++) {
            inputNumbers.add(input.nextInt());
        }
        input.close();
        filterNumsAndOutput(inputNumbers);
    }

    private static void getNumsFromFile(String source) {
        List<Integer> inputNumbers = new ArrayList<>();
        File sourceFile = new File(source);
        try {
            Scanner input = new Scanner(sourceFile);
            while (input.hasNextInt()) {
                inputNumbers.add(input.nextInt());
            }
            input.close();
            filterNumsAndOutput(inputNumbers);
        } catch (FileNotFoundException e) {
            System.err.println("Input file was not found. Make sure such file exists.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided for the application");
        } else if (args.length == 2) {
            outputFilename = args[1];
        }

        String source = args[0];
        try {
            getNumsFromConsole(Integer.parseInt(source));
        } catch (NumberFormatException e) {
            getNumsFromFile(source);
        }
    }
}
