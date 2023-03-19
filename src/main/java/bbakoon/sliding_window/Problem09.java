package bbakoon.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem09 {

    static int[] count = new int[4];
    static int answer = 0;
    static int A, C, G, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            add(s.charAt(i));
        }
        check();
        for (int i = M; i < N; i++) {
            add(s.charAt(i));
            remove(s.charAt(i - M));
            check();
        }
        System.out.println(answer);
    }

    private static void add(char c) {
        if (c == 'A') {
            count[0]++;
        } else if (c == 'C') {
            count[1]++;
        } else if (c == 'G') {
            count[2]++;
        } else {
            count[3]++;
        }
    }

    private static void remove(char c) {
        if (c == 'A') {
            count[0]--;
        } else if (c == 'C') {
            count[1]--;
        } else if (c == 'G') {
            count[2]--;
        } else {
            count[3]--;
        }
    }

    private static void check() {
        if (count[0] >= A && count[1] >= C && count[2] >= G && count[3] >= T) answer++;
    }
}
