package jobPrep2019.ibm;

import java.util.List;

public class aladdinCarpet {
    // lc134
    public static int optimalPoint(List<Integer> magic, List<Integer> dist) {
        // Write your code here
        int total = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < magic.size(); ++i) {
            sum += magic.get(i) - dist.get(i);
            total += magic.get(i) - dist.get(i);
            if (sum < 0) {
                sum = 0;
                res = i + 1;
            }
        }
        return total < 0 ? -1 : res;
    }
}
