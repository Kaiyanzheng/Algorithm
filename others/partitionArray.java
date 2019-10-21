package jobPrep2019.ibm;

import java.util.HashMap;
import java.util.List;

public class partitionArray {
    public static String solve(int k, List<Integer> numbers) {
        // Write your code here
        if (numbers == null || numbers.size() == 0 || numbers.size() % k != 0) return "No";
        int len = numbers.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.size() < k) return "No";
        else {
            for (Integer num : map.values()) {
                int max = 0;
                max = Math.max(max, num);
                if (max > len / k) return "No";
            }
        }
        return "Yes";
    }
}
