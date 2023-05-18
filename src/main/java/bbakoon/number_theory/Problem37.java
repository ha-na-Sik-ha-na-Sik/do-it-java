package bbakoon.number_theory;

import java.io.*;
import java.util.*;

public class Problem37 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            arr[i] = i;
        }
        arr[1] = 0;
        for (int i = 2; i <= Math.sqrt(M); i++) {
            if (arr[i] == 0) continue;
            for (int j = i + i; j <= M; j += i) {
                arr[j] = 0;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = N; i <= M; i++) {
            if (arr[i] != 0) answer.append(i).append("\n");
        }
        System.out.println(answer);
    }
}
