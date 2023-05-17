package dongmoo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem47 {
    static boolean[] visited;
    static List<Integer>[] A;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

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
            BFS(i);
            int visit = countVisit();
            if (visit > max) {
                answer = new ArrayList<>();
                answer.add(i);
                max = visit;
            } else if (visit == max) {
                answer.add(i);
            }
            initializeVisit();
        }

        Collections.sort(answer);
        answer.forEach(System.out::println);

    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int i : A[now_node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }

        }
    }

    public static int countVisit() {
        int answer = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                answer++;
            }
        }
        return answer;
    }

    public static void initializeVisit() {
        Arrays.fill(visited, false);
    }
}
