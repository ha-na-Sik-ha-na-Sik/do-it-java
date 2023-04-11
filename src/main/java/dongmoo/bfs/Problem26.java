package dongmoo.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem26 {
    //DFS 와 BFS 프로그램
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int E1 = Integer.parseInt(st.nextToken());
            int E2 = Integer.parseInt(st.nextToken());
            A[E1].add(E2);
            A[E2].add(E1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        dfs(V);

        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }
        System.out.println("");
        bfs(V);
    }

    public static void dfs(int V) {
        visited[V] = true;

        System.out.print(V + " ");

        for (int i : A[V]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int i : A[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
