package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10 {
    //최솟값 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int lp = 0;
        int rp = 0;

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        int min = A[0];
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int sequence = 0;
        int min_index = 0;

        while (rp < N) {
            int[] temp = new int[L];
            for (int i = lp; i < rp; i++) {

            }
            lp++;
            rp++;
        }

    }
}
