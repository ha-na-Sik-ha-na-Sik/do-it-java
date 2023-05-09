package bbakoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem31 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int S = 1;
        int E = k;
        int answer = 0;
        while (S <= E) {
            int M = (S + E) / 2;
            int min = calcMin(N, M);
            if (min < k) {
                S = M + 1;
            } else {
                answer = M;
                E = M - 1;
            }
        }
        System.out.println(answer);
    }

    public static int calcMin(int N, int M) {
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result += Math.min(M / i, N);
        }
        return result;
    }
}
