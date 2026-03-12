import java.util.*;

public class statement9 {
    public List<int[]> findTwoSum(int[] amounts, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> pairs = new ArrayList<>();
        for (int amt : amounts) {
            int complement = target - amt;
            if (map.containsKey(complement)) {
                pairs.add(new int[]{amt, complement});
            }
            map.put(amt, amt);
        }
        return pairs;
    }
}