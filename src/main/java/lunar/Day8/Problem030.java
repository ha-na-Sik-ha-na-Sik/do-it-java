package lunar.Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    블루레 5 이 크기에 대해 이분탐색
    start: 블루레이 한 개에 최소 값으로 최대 크기의 레슨 하나가 들어갈 수 있어야 함
    end: 블루레이 한 개에 최대 값으로 모든 레슨의 길이의 합이 들어갈 수 있어야 함
 */

public class Problem030 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            max += num[i];
        }

        find(m, max, num);
        System.out.println(answer);
    }

    public static void find(int m, int max, int[] num) {
        int start = num[num.length-1], end = max;

        while (end >= start) {
            int cnt = 1, sum = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < num.length; i++) {
                if (sum + num[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += num[i];
            }
            if (cnt > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        answer = start;
    }
}
