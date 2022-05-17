package com.danilovmaximov;

public interface NumbersFilter {
    /**
     * Filters numbers received from console.
     * @param amount amount of numbers to receive from console
     */
    void filterFromConsole(Integer amount);

    /**
     * Filters numbers received from file.
     * @param source name of file to be processed
     */
    void filterFromFile(String source);
}
