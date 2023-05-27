package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem08 {
    //좋은 수 구하기
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
        if (N == 1) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int sequence = 0; sequence < A.length; sequence++) {
            int lp = 0;
            int rp = A.length - 1;
            while (lp < rp) {
                if (A[lp] + A[rp] == A[sequence]) {
                    if (lp == sequence) {
                        lp++;
                    } else if (rp == sequence) {
                        rp--;
                    } else {
                        count++;
                        break;
                    }
                } else if (A[lp] + A[rp] > A[sequence]) {
                    rp--;
                } else {
                    lp++;
                }
            }
        }
        System.out.println(count);
    }
}
