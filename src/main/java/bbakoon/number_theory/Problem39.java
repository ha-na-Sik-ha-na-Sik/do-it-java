package bbakoon.number_theory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem39 {

    public static final int MAX = 10_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[MAX];
        for (int i = 2; i < MAX; i++) {
            arr[i] = i;
        }
        arr[1] = 0;
        for (int i = 2; i < MAX; i++) {
            if (arr[i] == 0) continue;
            for (int j = i + i; j < MAX; j += i) {
                arr[j] = 0;
            }
        }
        for (int i = N; i < MAX; i++) {
            if (arr[i] != 0) {
                if (check(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static boolean check(int n) {
        char[] c = String.valueOf(n).toCharArray();
        int S = 0;
        int E = c.length - 1;
        while (S < E) {
            if (c[S] != c[E]) return false;
            S++;
            E--;
        }
        return true;
    }
}
