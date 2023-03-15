package lunar.Day2;

import java.io.*;
import java.util.*;

//2차원 배열 + 구간합
public class Problem004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //수의 개수
        int m = Integer.parseInt(st.nextToken()); //합 구하는 개수
        int[][] num = new int[n][n]; //수 배열
        int[][] sum = new int[n + 1][n + 1]; //합 배열
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                num[i - 1][j - 1] = Integer.parseInt(st.nextToken());
                sum[i][j] += (num[i - 1][j - 1] + sum[i][j - 1]);
                if (i > 1 && j == 1) sum[i][j] += sum[i - 1][n];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            if(sy == 1) System.out.println(sum[ex][ey] - sum[sx-1][n]);
            else System.out.println(sum[ex][ey] - sum[sx][sy - 1]);
        }
    }
}
