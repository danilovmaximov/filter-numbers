package com.danilovmaximov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class NumbersFilterImpl implements NumbersFilter {
    @Override
    public List<Integer> filterFromConsole(Integer amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Amount of numbers must be a positive integer.");
        }
        List<Integer> receivedNumbers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < amount; i++) {
            receivedNumbers.add(input.nextInt());
        }
        input.close();
        return filter(receivedNumbers);
    }

    @Override
    public List<Integer> filterFromFile(String source) {
        List<Integer> receivedNumbers = new ArrayList<>();
        File sourceFile = new File(source);
        try {
            Scanner input = new Scanner(sourceFile);
            while (input.hasNextInt()) {
                receivedNumbers.add(input.nextInt());
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.err.println("Input file was not found. Make sure such file exists.");
            e.printStackTrace();
            exit(1);
        }
        return filter(receivedNumbers);
    }

    private List<Integer> filter(List<Integer> unfiltered) {
        final List<Integer> filtered;
        if (unfiltered.size() % 2 == 0) {
            filtered = unfiltered.stream()
                    .filter(num -> num % 2 == 0)
                    .collect(Collectors.toList());
        } else {
            filtered = unfiltered.stream()
                    .filter(num -> num % 2 != 0)
                    .collect(Collectors.toList());
        }
        return filtered;
    }
}
