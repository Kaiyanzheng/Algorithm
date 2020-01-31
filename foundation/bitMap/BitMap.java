package foundation.bitMap;

import java.util.BitSet;

public class BitMap {
    public static boolean isUniqueChars(String str) {
        if (str.length() > 256) {
            return false;
        }

        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void bitSet() {
        BitSet bitSet = new BitSet();
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.size());
        bitSet.set(0);
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.size());

        /**
         * 原始设定是将1向右移6位
         * 按2的6次方进行扩容
         */
        bitSet.set(65);
        System.out.println(bitSet.get(65));
        System.out.println(bitSet.size());

        bitSet.set(129);
        System.out.println(bitSet.get(129));
        System.out.println(bitSet.size());
    }


    public static int countDifferentBit(int num1, int num2) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (num1 & 1) ^ (num2 & 1);
            num1 >>= 1;
            num2 >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        //bitSet();
        System.out.println(countDifferentBit(6, 15));
    }
}
