package foundation.array;
import java.util.Arrays;
import java.util.ArrayList;

public class arrayList {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(); //capacity: 10
        // 两种 add, 加末尾 & 加入指定index  O(n)
        arrayList.add(1); //size: 1
        arrayList.add(2); //size: 2
        arrayList.add(3); //size: 3
        arrayList.add(0,0);
        //查找 index:O(1)/element:O(n)
        arrayList.contains(2);
        //修改 O(1)
        arrayList.set(0, 1);
        arrayList.get(0);
        //删除 O(n)
        arrayList.remove(0);
        arrayList.remove(1);

        arrayList.remove(1);
        System.out.println(Arrays.toString(arrayList.toArray()) + arrayList.size());

        //实现数组：增删改查
        //Size: 实际大小，Capacity: 容量大小
        

    }
}
