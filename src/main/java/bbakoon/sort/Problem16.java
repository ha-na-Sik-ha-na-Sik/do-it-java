package bbakoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem16 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = new Node(n, i);
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, arr[i].idx - i);
        }
        System.out.println(max + 1);
    }

    public static class Node implements Comparable<Node> {
        int n;
        int idx;

        public Node(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return this.n - o.n;
        }
    }
}
