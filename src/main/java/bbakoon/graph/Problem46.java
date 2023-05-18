package bbakoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem46 {

    static int N, M, K, X;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }
        bfs();
        Collections.sort(answer);
        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            for (Integer i : answer) {
                System.out.println(i);
            }
        }
    }

    public static void bfs() {
        boolean[] visited = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();
        visited[X] = true;
        queue.add(new Node(X, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.w == K) {
                answer.add(cur.v);
            } else if (cur.w > K) {
                break;
            }
            for (Integer i : adj[cur.v]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new Node(i, cur.w + 1));
                }
            }
        }
    }

    public static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
