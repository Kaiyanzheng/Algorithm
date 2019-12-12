package leetcode;

public class maxSatisfied_1052 {

    // LC 1052

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int base = 0;
        int maxGain = 0;
        for (int i = 0, gain = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) base += customers[i];
            else gain += customers[i];
            if (i >= X && grumpy[i - X] == 1) gain -= customers[i - X];
            maxGain = Math.max(maxGain, gain);
        }
        return base + maxGain;
    }

}
