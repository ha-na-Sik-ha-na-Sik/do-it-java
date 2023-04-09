package dongmoo.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem27 {

    static int[][] A;
    static boolean[][] visited;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int N;
    static int M;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 2][M + 2];
        visited = new boolean[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            int temp = 1;
            String[] split = br.readLine().split("");
            for (String s : split) {
                A[i][temp++] = Integer.parseInt(s);
            }

        }

        bfs(1, 1);

        System.out.println(A[N][M]);
    }

    public static void bfs(int y0, int x0) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y0, x0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nodeY = poll[0];
            int nodeX = poll[1];

            visited[nodeY][nodeX] = true;
            for (int i = 0; i < 4; i++) {
                int y1 = nodeY + dy[i];
                int x1 = nodeX + dx[i];
                if (A[y1][x1] != 0 && !visited[y1][x1]) {
                    visited[y1][x1] = true;
                    A[y1][x1] = A[nodeY][nodeX] + 1;
                    queue.add(new int[]{y1, x1});
                }
            }
        }
    }
}
