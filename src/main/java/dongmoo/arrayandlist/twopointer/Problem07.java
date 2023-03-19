package dongmoo.arrayandlist.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem07 {
    //주몽의 명령
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int lp = 0;
        int rp = A.length - 1;
        int cnt = 0;
        while (lp < rp) {
            if (A[lp] + A[rp] == M) {
                cnt++;
                lp++;
                rp--;
            } else if (A[lp] + A[rp] > M) {
                rp--;
            } else {
                lp++;
            }
        }
        System.out.println(cnt);

    }
}
