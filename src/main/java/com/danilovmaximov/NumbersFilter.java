package com.danilovmaximov;

import java.util.List;

public interface NumbersFilter {
    /**
     * Filters numbers received from console.
     * @param amount amount of numbers to receive from console
     */
    List<Integer> filterFromConsole(Integer amount);

    /**
     * Filters numbers received from file.
     * @param source name of file to be processed
     */
    List<Integer> filterFromFile (String source);

    /**
     * Prints list of integers to console.
     * @param source list to be printed
     */
    void printToConsole(List<Integer> source);

    /**
     * Prints list of integers to a file.
     * @param source list to be printed
     */
    void printToFile(List<Integer> source, String outputFileName);
}
