package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem46 {
	static ArrayList<Integer>[] A;
	static int[] visited;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];
		visited = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			A[i] = new ArrayList<>();
			visited[i] = -1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			A[u].add(v);
		}
		bfs(X);

		List<Integer> answers = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			if (visited[i] == K) {
				answers.add(i);
			}
		}

		if (answers.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(answers);
			answers.forEach(System.out::println);
		}
	}

	public static void bfs(int node) {
		Queue<Integer> myQueue = new LinkedList<>();
		myQueue.add(node);
		visited[node] = 0;

		while (!myQueue.isEmpty()) {
			int nowNode = myQueue.poll();
			for (int i : A[nowNode]) {
				if (visited[i] == -1) {
					myQueue.add(i);
					visited[i] = visited[nowNode] + 1;
				}
			}
		}
	}

}
