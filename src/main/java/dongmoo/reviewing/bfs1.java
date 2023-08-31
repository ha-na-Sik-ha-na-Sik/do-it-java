package dongmoo.reviewing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 26번 문제 : DFS 와 BFS 프로그램
public class bfs1 {

	static ArrayList<Integer>[] A;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			A[u].add(v);
			A[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(A[i]);
		}
		dfs(start);
	}

	public static void dfs(int node) {
		System.out.print(node + " ");
		visited[node] = true;
		for (int e : A[node]) {
			if (!visited[e]) {
				dfs(e);
			}
		}
	}
}
