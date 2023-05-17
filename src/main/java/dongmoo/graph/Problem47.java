package dongmoo.graph;

import java.io.*;
import java.util.*;

public class Problem47 {
    static boolean[] visited;
    static List<Integer>[] A;
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
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            A[start].add(end);
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
