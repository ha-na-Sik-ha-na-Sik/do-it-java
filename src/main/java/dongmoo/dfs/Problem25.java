package dongmoo.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem25 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrived;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        visited = new boolean[N];
        arrived = false;


        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (arrived) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static void dfs(int i, int depth) {
        if (depth == 5) {
            arrived = true;
            return;
        }
        visited[i] = true;
        for (int integer : A[i]) {
            if (!visited[integer]) {
                dfs(integer, depth + 1);
            }
        }
        visited[i] = false;
    }
}
