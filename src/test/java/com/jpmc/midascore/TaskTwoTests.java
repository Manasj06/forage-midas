package com.jpmc.midascore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTwoTests {

    @Test
    void task_two_verifier() {
        FileLoader fileLoader = new FileLoader();

        String[] data = fileLoader
                .loadStrings("/test_data/poiuytrewq.uiop")
                .toArray(new String[0]);

        assertEquals(3, data.length);
    }
}