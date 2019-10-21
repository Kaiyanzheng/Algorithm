package jobPrep2019.ibm;

public class shiftStrings {
    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        // Write your code here
        if (s == null || s.length() <= 1) return s;
        int len = s.length();
        int leftShift = leftShifts - rightShifts;
        leftShift = leftShift % len;
        if (leftShift == 0) {
            return s;
        } else if (leftShift > 0) {
            return s.substring(leftShift) + s.substring(0, leftShift);
        } else {
            int rightShift = Math.abs(leftShift);
            return s.substring(len - rightShift) + s.substring(0, len - rightShift);
        }
    }
}
