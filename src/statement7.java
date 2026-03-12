import java.util.*;

public class statement7 {
    private Map<String, Integer> frequencies = new HashMap<>();

    public void updateFrequency(String query) {
        frequencies.put(query, frequencies.getOrDefault(query, 0) + 1);
    }

    public List<String> search(String prefix) {
        // Simple implementation: Filter keys by prefix and sort by frequency
        return frequencies.entrySet().stream()
                .filter(e -> e.getKey().startsWith(prefix))
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }
}