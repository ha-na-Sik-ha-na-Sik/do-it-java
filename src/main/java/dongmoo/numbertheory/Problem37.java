package dongmoo.numbertheory;

import java.util.Scanner;

public class Problem37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] A = new int[N];
        boolean[] visited = new boolean[N];
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            A[i - 1] = i;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                continue;
            }
            if (!visited[i]) {
                if (A[i] >= M) {
                    System.out.println(A[i]);
                    answer++;
                }
                for (int j = i; j < A.length; j += A[i]) {
                    visited[j] = true;
                }
            }
        }
    }
}
