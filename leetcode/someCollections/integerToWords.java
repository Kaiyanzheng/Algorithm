package leetcode.someCollections;

public class integerToWords {
    /**
     * LC 273
     * input 小于 1000
     */

    private final static String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private final static String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        helper(sb, num);
        return sb.toString().trim();
    }

    private static void helper(StringBuilder sb, int num) {
        if (num == 0) {
            return;
        } else if (num < 20) {
            sb.append(LESS_THAN_20[num]).append(" ");
            return;
        } else if (num < 100) {
            sb.append(TENS[num / 10]).append(" ");
            helper(sb, num % 10);
        } else {
            sb.append(LESS_THAN_20[num / 100]).append(" Hundred ");
            helper(sb, num % 100);
        }
    }

    public static void main(String[] args) {
        String word = numberToWords(123);
        System.out.println(word.toCharArray());
    }
}
