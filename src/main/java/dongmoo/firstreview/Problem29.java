package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem29 {
    // 원하는 정수 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] MA = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int search = Integer.parseInt(st.nextToken());
            MA[i] = 0;

            int lp = 0;
            int rp = A.length - 1;
            while (lp<=rp) {
                int index = (lp + rp) / 2;
                if (A[index] == search) {
                    MA[i] = 1;
                    break;
                } else if (A[index] > search) {
                    rp = index - 1;
                } else {
                    lp = index + 1;
                }
            }
        }
        for (int i : MA) {
            System.out.println(i);
        }
    }
}
