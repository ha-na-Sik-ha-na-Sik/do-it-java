package bbakoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem47 {

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }
        for (int i = 1; i <= N; i++) {
            bfs(i);
        }
        int max = 0;
        StringBuilder answer = new StringBuilder();
        for (int i : count) {
            max = Math.max(max, i);
        }
        for (int i = 1; i <= N; i++) {
            if (count[i] == max) {
                answer.append(i).append(" ");
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int S) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[S] = true;
        queue.add(S);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (cur != S) {
                count[cur]++;
            }
            for (Integer i : adj[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
