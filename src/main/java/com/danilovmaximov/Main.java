package com.danilovmaximov;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided for the application");
        }

        NumbersFilter filter = new NumbersFilterImpl();
        List<Integer> filteredNumbers;

        String source = args[0];
        try {
            filteredNumbers = filter.filterFromConsole(Integer.parseInt(source));
        } catch (NumberFormatException e) {
            filteredNumbers = filter.filterFromFile(source);
        }

        if (args.length == 2) {
            filter.printToFile(filteredNumbers, args[1]);
        } else {
            filter.printToConsole(filteredNumbers);
        }
    }
}
