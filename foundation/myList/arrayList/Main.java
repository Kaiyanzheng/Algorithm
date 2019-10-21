package foundation.myList.arrayList;

import foundation.myList.arrayList.impl.ArrayListImpl;

public class Main {

    //测试
    public static void main(String[] args) {
        ArrayListImpl arrayList = new ArrayListImpl();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(0, 0);
        arrayList.remove(1);
        arrayList.remove(0);
        arrayList.print();
        arrayList.set(0,1);
        //System.out.println(arrayList.get(0));
        arrayList.print();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        arrayList.print();

        for (int i = 0; i < 11; i++) {
            arrayList.add(i);
        }
        arrayList.print();

        arrayList.remove(0);
        arrayList.print();

        /**
         * lazy 思想
         * 到了临街条件先不处理
         * 其他应用：Segment Tree
         */
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.print();

    }
}
