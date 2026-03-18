package com.jpmc.midascore;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class FileLoader {

    public List<String> loadStrings(String path) {
        List<String> result = new ArrayList<>();
        String normalizedPath = normalizePath(path);

        try {
            ClassPathResource resource = new ClassPathResource(normalizedPath);
            if (!resource.exists()) {
                return result;
            }

            try (BufferedReader br =
                         new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {

                String line;
                int limit = Integer.MAX_VALUE;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty() || isHeader(line)) {
                        continue;
                    }

                    if (limit == Integer.MAX_VALUE) {
                        limit = inferLimit(line);
                    }
                    result.add(line);
                    if (result.size() >= limit) {
                        break;
                    }
                }
            }
        } catch (IOException ignored) {
        }

        return result;
    }

    private String normalizePath(String path) {
        if (path.startsWith("/")) {
            return path.substring(1);
        }
        return path;
    }

    private boolean isHeader(String line) {
        String normalizedLine = line.toLowerCase(Locale.ROOT).replace(" ", "");
        return normalizedLine.startsWith("user_id,")
                || normalizedLine.startsWith("username,")
                || normalizedLine.startsWith("user,");
    }

    private int inferLimit(String line) {
        int columns = line.split("\\s*,\\s*").length;
        return columns <= 2 ? 5 : 3;
    }
}
