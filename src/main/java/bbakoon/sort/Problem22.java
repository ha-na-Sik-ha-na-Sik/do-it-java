package bbakoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem22 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            count[n]++;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            while (count[i] > 0) {
                answer.append(i).append("\n");
                count[i]--;
            }
        }
        System.out.println(answer);
    }
}
