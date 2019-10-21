package jobPrep2019.google;

public class waterFlower {
    /**
     * 用水壶从左到右一排植物浇水，一个int[] 代‍‌‌‍‌‍‌‍‍‌‌‌‍‌‌‌‍‌‌表每个植物需要得水，一个int代表水壶容量，每个植物必须一次浇完，要是水壶剩余的水不够，必须走回起点处加满水再过来，算总的步数。
     * 对，从左向右，就是把过程模拟一遍，下面说performance不是主要考虑因素 水桶一定比需要的水量大
     *
     * 直接照着规则模拟就好
     * 从第一朵花开始遍历，可以浇花就浇花，剩余水量不够就回去补水
     *
     * 有一个水桶容量是C，每朵花需要的水量是Ai(1<=i<=N)，i=0是补水站
     * 需要依序浇水，如果水桶剩余水量不够就必须i=0补水
     * 一开始在i=0，问浇完所有‍‌‌‍‌‍‌‍‍‌‌‌‍‌‌‌‍‌‌花的最少移动步数
     * sample:
     * C = 3, A = [2, 2, 1, 1, 2]
     * 移动路径: 0->1->0->2->3->0->4->5 total=13
     */

    public int getDistance(int[] plants, int capacity) {
        int step = 1;
        int remain = capacity - plants[0];
        for (int i = 1; i < plants.length; i++) {
            if (plants[i] <= remain) {
                step++;
                remain -= plants[i];
                continue;
            } else {
                step += 2 * i;
                remain = capacity;
                i--;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        waterFlower sol = new waterFlower();
        int[] plants = new int[]{2, 2, 1, 1, 2};
        int capacity = 3;
        int res = sol.getDistance(plants, capacity);
        System.out.println(res);
    }

}
