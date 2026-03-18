package com.jpmc.midascore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskThreeTests {

    @Test
    void task_three_verifier() {
        FileLoader fileLoader = new FileLoader();

        String[] data = fileLoader
                .loadStrings("/test_data/lkjhgfdsa.hjkl")
                .toArray(new String[0]);

        assertEquals(5, data.length);
    }
}