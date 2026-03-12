import java.util.*;

public class  statement3 {
    private Map<String, Set<String>> nGramMap = new HashMap<>();

    public void indexDocument(String docId, String text) {
        String[] words = text.split("\\s+");
        for (int i = 0; i <= words.length - 5; i++) {
            String nGram = String.join(" ", Arrays.copyOfRange(words, i, i + 5));
            nGramMap.computeIfAbsent(nGram, k -> new HashSet<>()).add(docId);
        }
    }

    // Logic: Count shared n-grams between docA and docB
}