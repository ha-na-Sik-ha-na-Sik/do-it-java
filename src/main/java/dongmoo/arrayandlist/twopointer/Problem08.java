package dongmoo.arrayandlist.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            long find = A[i];
            int lp = 0;
            int rp = N - 1;
            while (lp < rp) {
                if (A[lp] + A[rp] == find) {
                    if (lp != i && rp != i) {
                        cnt++;
                        break;
                    } else if (lp == i) {
                        lp++;
                    } else if (rp == i) {
                        rp--;
                    }
                } else if (A[lp] + A[rp] < find) {
                    lp++;
                } else {
                    rp--;
                }
            }

        }
        System.out.println(cnt);
    }
}
