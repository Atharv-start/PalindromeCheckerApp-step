import java.util.concurrent.ConcurrentHashMap;

class TokenBucket {
    long tokens;
    long lastRefill;
    final long limit = 1000;

    synchronized boolean allowRequest() {
        refill();
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        // Logic to add tokens based on time passed
    }
}

public class statement6 {
    private ConcurrentHashMap<String, TokenBucket> clients = new ConcurrentHashMap<>();
}