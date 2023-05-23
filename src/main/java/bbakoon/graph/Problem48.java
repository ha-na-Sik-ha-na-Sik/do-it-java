package bbakoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem48 {

    static int V, E;
    static ArrayList<Integer>[] adj;
    static int[] color;
    static boolean isBinaryGraph;
    static final int BLACK = 1;
    static final int RED = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adj = new ArrayList[V + 1];
            color = new int[V + 1];
            isBinaryGraph = true;
            for (int i = 1; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                adj[v].add(u);
            }
            for (int i = 1; i <= V; i++) {
                if (!isBinaryGraph) break;
                if (color[i] == 0) {
                    bfs(i);
                }
            }
            System.out.println(isBinaryGraph ? "YES" : "NO");
        }
    }

    public static void bfs(int S) {
        color[S] = BLACK;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (Integer i : adj[cur]) {
                if (color[i] == 0) {
                    color[i] = color[cur] == BLACK ? RED : BLACK;
                    queue.add(i);
                } else if (color[i] == color[cur]){
                    isBinaryGraph = false;
                    break;
                }
            }
        }
    }
}
