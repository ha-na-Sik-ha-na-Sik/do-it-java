package dongmoo.numbertheory;

import java.util.Scanner;

// 소수 & 팰린드롬 수 중에서 최솟값 찾기
public class Problem39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[10000001];

        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j < A.length; j += i) {
                A[j] = 0;
            }
        }

        for (int i : A) {
            if (i == 0) {
                continue;
            }
            if (i >= N && palindrome(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    public static boolean palindrome(int n) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
