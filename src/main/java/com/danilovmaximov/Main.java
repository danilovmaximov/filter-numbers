package com.danilovmaximov;

public class Main {
    static NumbersFilter filter;

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided for the application");
        } else if (args.length == 2) {
            // output file is specified
            filter = new NumberFilterImpl(args[1]);
        } else {
            // output file is not specified
            filter = new NumberFilterImpl();
        }

        String source = args[0];
        try {
            filter.filterFromConsole(Integer.parseInt(source));
        } catch (NumberFormatException e) {
            filter.filterFromFile(source);
        }
    }
}
