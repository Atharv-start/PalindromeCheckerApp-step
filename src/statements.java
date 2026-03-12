import java.util.*;

class UsernameChecker {

    private HashMap<String, Integer> usernameToUserId = new HashMap<>();
    private HashMap<String, Integer> attemptFrequency = new HashMap<>();

    public boolean checkAvailability(String username) {
        attemptFrequency.put(username, attemptFrequency.getOrDefault(username, 0) + 1);
        return !usernameToUserId.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        usernameToUserId.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            String alt = username + i;
            if (!usernameToUserId.containsKey(alt))
                suggestions.add(alt);
        }

        String modified = username.replace("_", ".");
        if (!usernameToUserId.containsKey(modified))
            suggestions.add(modified);

        return suggestions;
    }

    public String getMostAttempted() {
        return Collections.max(attemptFrequency.entrySet(),
                Map.Entry.comparingByValue()).getKey();
    }
}