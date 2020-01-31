package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _247_strobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        List<String> cur = new ArrayList<>();
        List<String> res = new ArrayList<>();

        if (n % 2 == 0) res = Arrays.asList("");
        else res = Arrays.asList("0", "1", "8");
        if (n < 2) return res;

        while (n > 1) {
            cur = res;
            System.out.println(" * ");
            for (int i = 0; i < cur.size(); i++) {
                System.out.print(cur.get(i));
            }
            res = new ArrayList<>();
            for (String i : cur) {
                if (n > 3) res.add('0' + i + '0');
                res.add('1' + i + '1');
                res.add('8' + i + '8');
                res.add('6' + i + '9');
                res.add('9' + i + '6');
            }
            n -= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        _247_strobogrammaticNumberII sol = new _247_strobogrammaticNumberII();
        sol.findStrobogrammatic(5);
    }

}
