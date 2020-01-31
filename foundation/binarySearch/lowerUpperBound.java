package foundation.binarySearch;

public class lowerUpperBound {

    public static int lowerBound(int[] arr, int val) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= val) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int upperBound(int[] arr, int val) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        int val = 2;
        System.out.println(lowerBound(arr, val)); // 1
        System.out.println(upperBound(arr, val)); // 3
    }
}
