package foundation.random;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickIndex {

    int[] nums;
    Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        return list.get(random.nextInt(list.size()));
    }

    /**
     * 数据流
     * 蓄水池抽样 reservoir sampling
     * 只取第一个对象
     * @param target
     * @return
     */
    public int pick2(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            count++;
            if (random.nextInt(count) == 0) {
                res = i;
            }
        }
        return res;
    }

    /**
     * 数据流
     * 蓄水池抽样 reservoir sampling
     * 抽取 K 个
     * @param stream
     * @param k
     * @return
     */
    public int[] reservoirSampling(int[] stream, int k) {
        Random rmd = new Random();
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = stream[i];
        }

        for (int i = k; i < stream.length; i++) {
            int random = rmd.nextInt(i + 1);
            if (random < k) {
                res[random] = stream[i];
            }
        }
        return res;
    }
}
