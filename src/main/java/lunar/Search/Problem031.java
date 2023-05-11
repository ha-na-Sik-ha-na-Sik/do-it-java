package lunar.Search;

import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Problem031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        /* 배열에 미리 다 저장하면 메모리 초과
        int b = (int) Math.pow(n, 2);
        int[] B = new int[b];

        b = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <=n; j++){
                B[b++] = i * j;
            }
        }

        Arrays.sort(B);
        System.out.println(B[k]);
         */

        int start = 1, end = k, cnt = 0, answer = 0;
        while(end >= start){
            int mid = (start + end) / 2;

            for(int i = 1; i <= n; i++) {
                int r = (int) mid / i;
                if(r > n){
                    r = n;
                }
                cnt += r;
            }

            if(cnt < k) start = mid + 1;
            else { answer = mid; end = mid - 1; }
            cnt = 0;
        }

        System.out.println(answer);
    }
}
