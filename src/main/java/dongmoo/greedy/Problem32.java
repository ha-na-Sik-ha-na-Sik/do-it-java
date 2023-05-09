package dongmoo.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem32 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            A[i] = value;
        }

        for (int i = N - 1; i >= 0; i--) {
            if (K <= 0) {
                break;
            }
            int num = K / A[i];
            answer += num;
            K -= num * A[i];
        }

        System.out.println(answer);

    }
}
