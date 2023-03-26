package dongmoo.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        Map<Integer, Integer> B = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            A[i] = input;
            B.put(input, i);
        }

        Arrays.sort(A);
        int max = 0;

        for (int i = 0; i < N; i++) {
            int key = B.get(A[i]);
            max = Math.max(key - i, max);
        }

        System.out.println(max + 1);
    }
}
