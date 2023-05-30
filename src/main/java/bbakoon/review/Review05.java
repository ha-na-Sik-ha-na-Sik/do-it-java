package bbakoon.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Review05 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] prefix = new int[N + 1];
        int M = Integer.parseInt(st.nextToken());
        int[] C = new int[M];

        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
            int remainder = prefix[i] % M;
            if (remainder == 0) answer++;
            C[remainder]++;
        }
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer += C[i] * (C[i] - 1) / 2;
            }
        }
        System.out.println(answer);
    }
}
