package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class prefixSearch {
    /** 输出顺序不重要 */
    public static List<String> prefixSearch (List<String> names, String key) {
        List<String> res = new ArrayList<>();
        for (String name : names) {
            String[] subs = name.split(" ");
            for (String sub : subs) {
                if (sub.toLowerCase().startsWith(key)) {
                    res.add(name);
                    break;
                }
            }
        }
        // Collections.sort(res, String::compareTo); // (a, b) -> a.compareTo(b) 按字母表顺序
        return res;
    }

    /** 按出现的 index 排序返回 */
    public static List<String> prefixSearch1 (List<String> names, String key) {
        List<String> res = new ArrayList<>();
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (String name : names) {
            int index = 0;
            String[] subs = name.split(" ");
            for (String sub : subs) {
                if (sub.toLowerCase().startsWith(key)) {
                    map.putIfAbsent(index, new ArrayList<>());
                    map.get(index).add(name);
                    break;
                }
                index++;
            }
        }
        for (Integer index : map.keySet()) {
            // Collections.sort(map.get(index), String::compareTo);
            for (String name : map.get(index)) {
                res.add(name);
            }

        }
        return res;
    }

    /** 暴力解
     *  sub:  walburg
     *           i
     *  key:  bur
     *        j
     *  */
    public static List<String> nonPrefixSearch_bruteforce (List<String> names, String key) {
        List<String> res = new ArrayList<>();
        for (String name : names) {
            String[] subs = name.split(" ");
            for (String sub : subs) {
                sub = sub.toLowerCase();
                if (sub.length() < key.length()) continue;
                for (int i = 0; i <= sub.length() - key.length(); i++) {
                    int j = 0;
                    while (j < key.length()) {
                        if (sub.charAt(i + j) != key.charAt(j)) break;
                        else j++;
                    }
                    if (j == key.length()) {
                        res.add(name);
                        break;
                    }
                }
            }
        }
        // Collections.sort(res, String::compareTo); // (a, b) -> a.compareTo(b) 按字母表顺序
        return res;
    }

    /** KMP */
    public static List<String> nonPrefixSearch_KMP (List<String> names, String key) {
        List<String> res = new ArrayList<>();
        for (String name : names) {
            String[] subs = name.split(" ");
            for (String sub : subs) {
                sub = sub.toLowerCase();
                if (kmpHelper(sub, key)) {
                    res.add(name);
                    break;
                }

            }
        }
        return res;
    }
    private static boolean kmpHelper(String str, String key) {
        //create Prefix Table,  最长公共前后缀
        int[] pTable = new int[key.length()];
        for (int i = 1; i < key.length(); i++) {
            int t = pTable[i - 1];
            while (t > 0 && key.charAt(i) != key.charAt(t)) {
                t = pTable[t - 1];
            }
            if (key.charAt(i) == key.charAt(t)) t++;
            pTable[i] = t;
        }
        // matching
        int i = 0, j = 0;
        while (i < str.length()) {
            if (j == key.length()) return true;
            if (str.charAt(i++) == key.charAt(j++)) {
                continue;
            } else {
                if (j == 0) {
                    i++;
                    continue;
                }
                j = pTable[j - 1];
                continue;
            }
        }
        return j == key.length();
    }


    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Burger King");
        names.add("kdk dnsd Burgers");
        names.add("sad Burger's");
        names.add("aad Burger's");
        names.add("asdd das a");
        names.add("Walburgers");
//        List<String> res = prefixSearch1(names, "bur");
//        for (String s : res) System.out.println(s);
        List<String> res = nonPrefixSearch_KMP(names, "bur");
        for (String s : res) System.out.println(s);
    }
}
