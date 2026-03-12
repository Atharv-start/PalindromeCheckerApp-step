import java.util.*;

class DNSEntry {
    String ip;
    long expiryTime;
    DNSEntry(String ip, long ttlSeconds) {
        this.ip = ip;
        this.expiryTime = System.currentTimeMillis() + (ttlSeconds * 1000);
    }
}

public class statemet2 {
    private Map<String, DNSEntry> cache = new HashMap<>();

    public String resolve(String domain) {
        DNSEntry entry = cache.get(domain);
        if (entry != null && System.currentTimeMillis() < entry.expiryTime) {
            return "Cache HIT -> " + entry.ip;
        }
        // Simulate Upstream Query
        String newIp = "172.217.14." + (new Random().nextInt(255));
        cache.put(domain, new DNSEntry(newIp, 300));
        return "Cache MISS/EXPIRED -> Query upstream -> " + newIp;
    }
}