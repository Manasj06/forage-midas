package com.jpmc.midascore;

import com.jpmc.midascore.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskFourTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPopulator userPopulator;

    @Test
    void task_four_verifier() {
        userPopulator.populate();
        assertEquals(5, userRepository.findAll().size());
    }
}