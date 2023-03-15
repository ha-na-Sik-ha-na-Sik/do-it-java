package lunar.Day2;

import java.io.*;
import java.util.*;

//배열 + 구간합
public class Problem005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        int[] sum = new int[n];
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum[i] += num[i];
            if(i > 0) sum[i] += sum[i-1];
            if(sum[i] % m == 0) cnt++;
        }

        for(int i = 0; i < n; i++){
            for(int j = n-1; j > i; j--) {
                if ((sum[j] - sum[i]) % m == 0) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
