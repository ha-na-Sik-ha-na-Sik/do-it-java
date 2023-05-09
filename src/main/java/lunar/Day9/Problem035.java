package lunar.Day9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] start, int[] end) {
                if (start[1] == end[1]) {
                    return start[0] - end[0];
                }
                return start[1] - end[1];
            }
        });

        int cnt = 0, end = -1;

        for (int i = 0; i < n; i++) {
            if (time[i][0] >= end) {
                end = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
