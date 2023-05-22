package bbakoon.number_theory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem38 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        long[] arr = new long[10_000_001];
        for (int i = 2; i <= 10_000_000; i++) {
            arr[i] = i;
        }
        arr[1] = 0;
        for (int i = 2; i <= Math.sqrt(10_000_000); i++) {
            if (arr[i] == 0) continue;
            for (int j = i + i; j <= 10_000_000; j += i) {
                arr[j] = 0;
            }
        }
        long answer = 0;
        for (int i = 2; i <= 10_000_000; i++) {
            if (arr[i] != 0) {
                long cur = arr[i];
                while ((double) arr[i] <= (double) M / (double) cur) {
                    if ((double) arr[i] >= (double) N / (double) cur) {
                        answer++;
                    }
                    cur *= arr[i];
                }
            }
        }
        System.out.println(answer);
    }
}
