package dongmoo.resolving;

import java.util.*;
import java.io.*;

public class Problem23 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N+1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int E = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            A[E].add(S);
            A[S].add(E);
        }
        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                bfs(i);
            }
        }
        System.out.println(count);
    }

    public static void bfs(int n) {
        if (visited[n]) {
            return;
        }

        visited[n] =true;

        for (int i : A[n]) {
            if (!visited[i]) {
                bfs(i);
            }
        }
    }

}
