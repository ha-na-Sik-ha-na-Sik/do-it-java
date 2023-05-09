package bbakoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem07 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int L = 0;
        int R = N - 1;
        int answer = 0;
        while (L < R) {
            int sum = arr[L] + arr[R];
            if (sum == M) {
                answer++;
                L++;
                R--;
            } else if (sum > M) {
                R--;
            } else {
                L++;
            }
        }
        System.out.println(answer);
    }
}
