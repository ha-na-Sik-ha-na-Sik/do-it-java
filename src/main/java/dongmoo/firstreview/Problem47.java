package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem47 {
	static List<Integer>[] A;
	static boolean[] visited;
	static List<Integer> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			A[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			A[u].add(v);
		}

		int max = 0;

		for (int i = 1; i <= N; i++) {
			int visit = BFS(i);
			if (visit > max) {
				answer = new ArrayList<>();
				answer.add(i);
				max = visit;
			} else if (visit == max) {
				answer.add(i);
			}
			visited = new boolean[N + 1];
		}

		Collections.sort(answer);
		for (Integer integer : answer) {
			bw.write(integer + " ");
		}

		bw.flush();
	}

	public static int BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		queue.add(node);
		visited[node] = true;

		while (!queue.isEmpty()) {
			int now_node = queue.poll();
			for (int i : A[now_node]) {
				if (!visited[i]) {
					count++;
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		return count;
	}
}
