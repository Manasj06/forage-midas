package com.jpmc.midascore;

import com.jpmc.midascore.component.DatabaseConduit;
import com.jpmc.midascore.entity.UserRecord;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserPopulator {

    private final FileLoader fileLoader;
    private final DatabaseConduit databaseConduit;

    public UserPopulator(FileLoader fileLoader, DatabaseConduit databaseConduit) {
        this.fileLoader = fileLoader;
        this.databaseConduit = databaseConduit;
    }

    public int populate() {
        int populatedCount = 0;
        for (String userLine : loadUserLines()) {
            String[] userData = userLine.split("\\s*,\\s*");
            if (userData.length < 2) {
                continue;
            }

            String username = userData[0];
            try {
                float balance = Float.parseFloat(userData[1]);
                if (!databaseConduit.existsByUsername(username)) {
                    databaseConduit.saveUser(new UserRecord(username, balance));
                    populatedCount++;
                }
            } catch (NumberFormatException ignored) {
            }
        }

        return populatedCount;
    }

    private List<String> loadUserLines() {
        String[] candidatePaths = {
                "/valid_users.csv",
                "valid_users.csv",
                "/test_data/lkjhgfdsa.hjkl",
                "test_data/lkjhgfdsa.hjkl"
        };

        for (String candidatePath : candidatePaths) {
            List<String> userLines = fileLoader.loadStrings(candidatePath);
            if (!userLines.isEmpty()) {
                return userLines;
            }
        }

        return List.of();
    }
}
