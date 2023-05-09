package bbakoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem29 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            answer.append(binarySearch(target, 0, N - 1)).append("\n");
        }
        System.out.println(answer);
    }

    public static int binarySearch(int target, int S, int E) {
        while (S <= E) {
            int M = (S + E) / 2;
            if (target == arr[M]) {
                return 1;
            } else if (target > arr[M]) {
                S = M + 1;
            } else {
                E = M - 1;
            }
        }
        return 0;
    }
}
