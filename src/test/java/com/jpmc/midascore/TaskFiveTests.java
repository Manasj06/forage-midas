package com.jpmc.midascore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFiveTests {

    @Test
    void task_five_verifier() {
        FileLoader fileLoader = new FileLoader();

        String[] data = fileLoader
                .loadStrings("/test_data/lkjhgfdsa.hjkl")
                .toArray(new String[0]);

        assertTrue(data.length > 0);
    }
}