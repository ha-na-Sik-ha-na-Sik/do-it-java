package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem30 {
    // 블루레이 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int sum = 0;
        int max = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            A[i] = a;
            sum += a;
            max = Math.max(max, a);
        }

        int lp = max;
        int rp = sum;
        while (lp <= rp) {
            int length = (lp + rp) / 2;
            int temp_sum = 0;
            int blue_ray_count = 0;
            for (int i = 0; i < N; i++) {
                if (temp_sum + A[i] > length) {
                    temp_sum = 0;
                    blue_ray_count++;
                }
                temp_sum += A[i];

            }
            if (sum != 0) {
                blue_ray_count++;
            }
            if (blue_ray_count > M) {
                lp = length + 1;
            } else {
                rp = length - 1;
            }
        }
        System.out.println(lp);
    }
}
