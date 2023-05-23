package dongmoo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 이분 그래프 판별하기
public class Problem48 {
    static boolean[] visited;
    static List<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());
        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];

            for (int j = 0; j < A.length; j++) {
                A[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                A[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            }


        }
    }

    public static void DFS(int startNode)
}
