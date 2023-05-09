package bbakoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem24 {

    static int N;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        System.out.println(answer);
    }

    public static void dfs(int n, int depth) {
        if (depth == N) {
            answer.append(n).append("\n");
            return;
        }
        for (int i = 1; i <= 9; i += 2) {
            int newNum = n * 10 + i;
            if (isPrime(newNum)) {
                dfs(newNum, depth + 1);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
