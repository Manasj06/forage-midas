package com.jpmc.midascore.component;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseConduit {

    private final UserRepository userRepository;

    public DatabaseConduit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRecord save(UserRecord userRecord) {
        return userRepository.save(userRecord);
    }

    // Used by UserPopulator
    public void saveUser(UserRecord userRecord) {
        userRepository.save(userRecord);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public UserRecord findById(Long userId) {
        if (userId == null) {
            return null;
        }
        return userRepository.findById(userId).orElse(null);
    }

    public List<UserRecord> getAllUsers() {
        return userRepository.findAll();
    }
}
