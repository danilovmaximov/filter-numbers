package com.danilovmaximov;

import java.io.File;
import java.io.FileWriter;
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
    static void printToConsole(List<Integer> source) {
        System.out.println(source);
    }

    /**
     * Prints list of integers to a file.
     * @param source list to be printed
     * @param outputFileName name of file where goes the output
     */
    static void printToFile(List<Integer> source, String outputFileName) {
        try {
            File outputFile = new File(outputFileName);

            // If file does not exist, create it
            if (outputFile.getParentFile() != null) outputFile.getParentFile().mkdirs();
            outputFile.createNewFile();

            FileWriter output = new FileWriter(outputFile);
            output.write(source.toString());
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
