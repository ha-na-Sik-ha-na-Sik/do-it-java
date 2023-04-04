package bbakoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem25 {

    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean isFind = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (isFind) break;
        }
        System.out.println(isFind ? 1 : 0);
    }

    public static void dfs(int n, int depth) {
        if (depth == 5 || isFind) {
            isFind = true;
            return;
        }
        if (visited[n]) return;
        visited[n] = true;
        for (Integer i : adj[n]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[n] = false;
    }
}
