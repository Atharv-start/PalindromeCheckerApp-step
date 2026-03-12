import java.util.*;

public class statement10 {
    // L1: LinkedHashMap with accessOrder = true handles LRU automatically
    private LinkedHashMap<String, String> l1 = new LinkedHashMap<>(100, 0.75f, true);
    private Map<String, String> l2 = new HashMap<>();

    public String getVideo(String id) {
        if (l1.containsKey(id)) return l1.get(id); // L1 Hit
        if (l2.containsKey(id)) {
            String data = l2.get(id);
            l1.put(id, data); // Promote to L1
            return data;
        }
        return "Database Hit";
    }
}