import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class statement1 {
    private ConcurrentHashMap<String, AtomicInteger> inventory = new ConcurrentHashMap<>();
    private ConcurrentLinkedQueue<Integer> waitingList = new ConcurrentLinkedQueue<>();

    public void setStock(String productId, int count) {
        inventory.put(productId, new AtomicInteger(count));
    }

    public String purchaseItem(String productId, int userId) {
        AtomicInteger stock = inventory.get(productId);

        if (stock != null && stock.get() > 0) {
            if (stock.decrementAndGet() >= 0) {
                return "Success, " + stock.get() + " units remaining";
            }
        }

        waitingList.add(userId);
        return "Added to waiting list, position #" + waitingList.size();
    }
}