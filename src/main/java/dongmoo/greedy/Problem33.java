package dongmoo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] A = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(sc.nextLine());
        }

        Arrays.sort(A);

        if (N == 1) {
            answer = A[0];
        } else if (N == 2) {
            answer = A[0] + A[1];
        } else {
            answer += A[0] * (N - 1);
            for (int i = 1; i < N; i++) {
                answer += (N - i) * A[i];
            }
        }

        System.out.println(answer);
    }
}
