package jobPrep2019.amazon.eight;

import java.util.*;

public class reorderLog_lc937 {
    /**
     *  sort prime orders and non-prime orders
     * You have an array of logs.  Each log is a space delimited string of words.
     *
     * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
     *
     * Each word after the identifier will consist only of lowercase letters, or;
     * Each word after the identifier will consist only of digits.
     * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
     *
     * Reorder the logs so that all of the letter-logs come before any digit-log.
     * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
     * The digit-logs should be put in their original order.
     * Return the final order of the logs.
     *
     *
     * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
     * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
     *
     * Note:
     * 0 <= logs.length <= 100
     * 3 <= logs[i].length <= 100
     * logs[i] is guaranteed to have an identifier, and a word after the identifier.


1. guaranteed to have a word following an identifier (allows me to use indexOf ' ' freely).
2. letter logs need to be ordered lexicographically, so we can use built in compare function when we know we have two.
3. number logs need to be sorted naturally, so we just say they're all "equal" to each other and trust java's built in sort feature to be stable.
4. number logs need to be after letter logs, so once we find out they're different, we return one of the other and short-circuit.
    */
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                int s1si = s1.indexOf(' ');
                int s2si = s2.indexOf(' ');
                char s1fc = s1.charAt(s1si + 1);
                char s2fc = s2.charAt(s2si + 1);

                if (s1fc <= '9') {
                    if (s2fc <= '9') return 0;
                    else return 1;
                }
                if (s2fc <= '9') return -1;

                int preCompute = s1.substring(s1si + 1).compareTo(s2.substring(s2si + 1));

                if (preCompute == 0) return s1.substring(0, s1si).compareTo(s2.substring(0, s2si));
                return preCompute;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }


    public List<String> reorderLogFiles(List<String> logs) {

        Comparator<String> myComp = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                int s1si = s1.indexOf(' ');
                int s2si = s2.indexOf(' ');
                char s1fc = s1.charAt(s1si + 1);
                char s2fc = s2.charAt(s2si + 1);

                if (s1fc <= '9') {
                    if (s2fc <= '9') return 0;
                    else return 1;
                }
                if (s2fc <= '9') return -1;

                int preCompute = s1.substring(s1si + 1).compareTo(s2.substring(s2si + 1));

                if (preCompute == 0) return s1.substring(0, s1si).compareTo(s2.substring(0, s2si));
                return preCompute;
            }
        };

        Collections.sort(logs, myComp);
        return logs;
    }



    public static void main(String[] args) {
        reorderLog_lc937 sol = new reorderLog_lc937();
        //String[] logs = new String[]{"a1 9 2 3 1", "g1 act car", "a1 act car", "a2 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        //String[] res = sol.reorderLogFiles(logs);
        List<String> logs = new ArrayList<>();
        logs.add("a1 9 2 3 1");
        logs.add("g1 act car");
        logs.add("a1 act car");
        logs.add("a2 act car");
        logs.add("zo4 4 7");
        logs.add("ab1 off key dog");
        logs.add("a8 act zoo");
        List<String> res = sol.reorderLogFiles(logs);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
