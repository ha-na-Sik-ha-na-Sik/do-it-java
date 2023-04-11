package bbakoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem26 {

    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
        dfs(V);
        visited = new boolean[N + 1];
        answer.append("\n");
        bfs();
        System.out.println(answer);
    }

    public static void dfs(int v) {
        visited[v] = true;
        answer.append(v).append(" ");
        for (Integer i : adj[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        visited[V] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            answer.append(cur).append(" ");
            for (Integer i : adj[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
