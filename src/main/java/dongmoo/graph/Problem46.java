package dongmoo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem46 {

    static int[] visited;
    static List<Integer>[] A;
    static int N;
    static int M;
    static int K;
    static int X;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
        }

        List<Integer> answer = new ArrayList<>();
        BFS(X);
        for (int i = 0; i <= N; i++) {
            if (visited[i] == K) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            answer.forEach(System.out::println);
        }
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for(int i : A[now_node]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now_node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
