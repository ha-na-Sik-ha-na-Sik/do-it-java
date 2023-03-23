package bbakoon.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<int[]> deq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            while (!deq.isEmpty() && deq.getLast()[0] >= n) {
                deq.removeLast();
            }
            if (!deq.isEmpty() && deq.getFirst()[1] < i - L + 1) {
                deq.removeFirst();
            }
            deq.addLast(new int[]{n, i});
            answer.append(deq.getFirst()[0]).append(" ");
        }
        System.out.println(answer);
    }
}
