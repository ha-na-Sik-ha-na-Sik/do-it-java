package dongmoo.arrayandlist.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem10 {
    static int D = 110;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < L; i++) {
            list.add(A[i]);
            D = Math.min(D, A[i]);
            System.out.print(D+ " ");
        }

        for (int i = 1; i <= N - L; i++) {
            list.remove(0);
            list.add(A[i + L - 1]);

            list.stream()
                    .mapToInt(x -> x)
                    .min().ifPresent(x -> System.out.print(x + " "));
        }
    }
}
