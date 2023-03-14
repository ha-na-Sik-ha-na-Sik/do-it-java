package lunar.Day2;

import java.io.*;
import java.util.*;

//배열 + 구간합
public class Problem003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //수의 개수
        int m = Integer.parseInt(st.nextToken()); //합 구하는 개수
        int[] num = new int[n]; //수 배열
        int[] sum = new int[n+1]; //합 배열
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            num[i-1] = Integer.parseInt(st.nextToken());
            sum[i] += num[i-1] + sum[i-1];
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); //시작
            int end = Integer.parseInt(st.nextToken()); //끝
            System.out.println(sum[end] - sum[start-1]);
        }
    }
}
