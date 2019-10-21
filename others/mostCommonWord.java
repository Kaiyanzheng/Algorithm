package jobPrep2019.amazon.other;

import com.sun.jdi.Value;

import java.util.*;

public class mostCommonWord {
    /**
     * 找出出现频率最高的词， 和lc 819 类似。
     * 给一个段落（包含各种特殊字符， 然后一个banned[]， 找出出现最高频的词不包括banned里的，可以是多个）
     * 把段落去掉特殊字符然后转换成字符组， 用map就可以解（注意的地方是转换的时候一定只保留词组，要不会有几个test case过不了。
     */


    public List<String> mostCommonWord(String literatureText, List<String> wordsToExclude) {
        String[] words = literatureText.toLowerCase().split("[ !?'’,;.]+");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordsToExclude.size(); i++) {
            String wordsToExcludeLower = wordsToExclude.get(i).toLowerCase();
            if (map.containsKey(wordsToExcludeLower)) {
                map.remove(wordsToExcludeLower);
            }
        }

        List<String> res = new ArrayList<>();
        int maxCount = 0;

        for (int count : map.values()) {
            maxCount = Math.max(maxCount, count);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        mostCommonWord sol = new mostCommonWord();
        String literatureText = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack’s and Jill’s favorite food.";
        List<String> wordsToExclude = new ArrayList<>();
        wordsToExclude.add("and");
        wordsToExclude.add("he");
        wordsToExclude.add("the");
        wordsToExclude.add("to");
        wordsToExclude.add("is");
        wordsToExclude.add("Jack");
        wordsToExclude.add("Jill");
        List<String> res = sol.mostCommonWord(literatureText, wordsToExclude);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
