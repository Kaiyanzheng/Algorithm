package leetcode;

public class minModification {

    public static int minModification(int[] target) {
        int res = 0;
        int max = -1;
        while (max != 1) {
            int sum = 0;
            max = target[0];
            int idx = 0;
            for (int i = 0; i < target.length; i++) {
                sum += target[i];
                if (target[i] > max) {
                    max = target[i];
                    idx = i;
                }
            }
            if (max == 1) break;
            target[idx] = 2 * max - sum;
            res++;
        }
        return res;
    }

    public static int minModification1(int[] target) {
        int res = 0;
        int max = -1;
        while (max != 1) {
            int sum = 0;
            max = target[0];
            int idx = 0;
            for (int i = 0; i < target.length; i++) {
                sum += target[i];
                if (target[i] > max) {
                    max = target[i];
                    idx = i;
                }
            }
            if (max == 1) break;
            target[idx] = 2 * max - sum;
            res++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] target1 = new int[]{9,29,17}; // 5
        System.out.println(minModification(target1));
        int[] target2 = new int[]{13,5,7}; // 4
        System.out.println(minModification(target2));
    }
}
