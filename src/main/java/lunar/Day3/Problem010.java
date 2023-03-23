package lunar.Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//슬라이딩 윈도우 (시간 초과)
public class Problem010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] D = new int[n];

        Deque<Node> deque = new ArrayDeque<>();
        int now = Integer.parseInt(st.nextToken());
        deque.add(new Node(0, now));
        D[0] = now;
        for(int i = 1; i < n; i++){
            now = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty()) {
                if (deque.peekLast().value > now) deque.pollLast();
                else break;
            }
            deque.addLast(new Node(i, now));
            if(deque.peekLast().idx - deque.peekFirst().idx == l) deque.pollFirst();
            D[i] = deque.peekFirst().value;
        }

        for(int i = 0; i < n; i++){
            System.out.print(D[i] + " ");
        }
    }

    static class Node{
        public int idx;
        public int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
