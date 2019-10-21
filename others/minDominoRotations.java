package jobPrep2019.google;

public class minDominoRotations {
    public int minDominoRotations1(int[] A, int[] B) {
        for (int i = 0, a = 0, b = 0; i <  A.length && (A[i] == A[0] || B[i] == A[0]); i++) {
            if (A[i] != A[0]) a++;
            if (B[i] != A[0]) b++;
            if (i == A.length - 1) return Math.min(a, b);
        }
        for (int i = 0, a = 0, b = 0; i < A.length && (A[i] == B[0] || B[i] == B[0]); i++) {
            if (A[i] != B[0]) a++;
            if (B[i] != B[0]) b++;
            if (i == A.length - 1) return Math.min(a, b);
        }
        return -1;
    }

    public int minDominoRotations(int[] A, int[] B) {
        int ACountA = 0;
        int ACountB = 0;
        for (int i = 0; i <  A.length; i++) {
            if (A[i] != A[0] && B[i] != A[0]) break;
            if (A[i] != A[0]) ACountA++;
            if (B[i] != A[0]) ACountB++;
            if (i == A.length - 1) return Math.min(ACountA, ACountB);
        }
        int BCountA = 0;
        int BCountB = 0;
        for (int i = 0; i < A.length; i++) {
            if ((B[i] != B[0] && A[i] != B[0])) break;
            if (A[i] != B[0]) BCountA++;
            if (B[i] != B[0]) BCountB++;
            if (i == A.length - 1) return Math.min(BCountA, BCountB);
        }
        return -1;
    }

    public static void main(String[] args) {
        minDominoRotations sol = new minDominoRotations();
        int[] A = new int[]{2, 1, 2, 4, 2, 2};
        int[] B = new int[]{5, 2, 6, 2, 3, 2};
        System.out.println(sol.minDominoRotations(A, B));
    }
}
