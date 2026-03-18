package com.jpmc.midascore.controller;

import com.jpmc.midascore.component.DatabaseConduit;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Balance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BalanceController {

    private final DatabaseConduit databaseConduit;

    public BalanceController(DatabaseConduit databaseConduit) {
        this.databaseConduit = databaseConduit;
    }

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
                "status", "running",
                "message", "Midas Core is up. Query balances with /balance?userId=<id>",
                "example", "/balance?userId=1"
        );
    }

    @GetMapping("/balance")
    public Balance getBalance(@RequestParam Long userId) {
        UserRecord userRecord = databaseConduit.findById(userId);
        float amount = userRecord == null ? 0.0f : userRecord.getBalance();
        return new Balance(amount);
    }
}
