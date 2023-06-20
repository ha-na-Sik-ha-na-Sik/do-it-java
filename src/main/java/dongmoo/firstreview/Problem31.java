package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem31 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long lp = 1;
        long rp = k;
        long ans = 0;

        while (lp <= rp) {
            long middle = (lp + rp) / 2;
            long cnt = 0;
            for (int i = 1; i < N + 1; i++) {
                cnt += Math.min(middle / i, N);
            }
            if (cnt < k) {
                lp = middle + 1;
            } else {
                ans = middle;
                rp = middle - 1;
            }
        }
        System.out.println(ans);
    }
}
