package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class domainCountClick {

    public static List<List<String>> countClick(String[][] array) {
        List<List<String>> res = new ArrayList<>();
        if (array == null || array.length == 0) return res;
        Map<String, Integer> map = new HashMap<>(); // domain, count
        for (String[] click : array) {
            String cur = click[0];
            int num = Integer.parseInt(click[1]);
            map.put(cur, map.getOrDefault(cur, 0) + num);
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) == '.') {
                    String domain = cur.substring(i + 1);
                    map.put(domain, map.getOrDefault(domain, 0) + num);
                }
            }
        }
        for (String domain : map.keySet()) {
            List<String> click = new ArrayList<>();
            click.add(domain);
            click.add(String.valueOf(map.get(domain)));
            res.add(click);
        }
        return res;
    }

    public static void main(String[] args) {
        String[][] array = new String[][]{{"google.com", "60"}, {"yahoo.com", "50"}, {"sports.yahoo.com", "80"}};
        List<List<String>> res = countClick(array);
        for (List<String> click : res) {
            System.out.println(click.get(0) + ", " + click.get(1));
        }
    }
}
