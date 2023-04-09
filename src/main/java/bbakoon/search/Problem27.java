package bbakoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem27 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1);
            }
        }
        bfs();
    }

    public static void bfs() {
        visited[1][1] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1, 1));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.i == N && cur.j == M) {
                System.out.println(cur.w);
                return;
            }
            for (int n = 0; n < 4; n++) {
                int x = cur.i + dx[n];
                int y = cur.j + dy[n];
                if (x <= 0 || x > N || y <= 0 || y > M || visited[x][y] || map[x][y] == '0') continue;
                visited[x][y] = true;
                queue.add(new Node(x, y, cur.w + 1));
            }
        }
    }

    public static class Node {
        int i;
        int j;
        int w;

        public Node(int i, int j, int w) {
            this.i = i;
            this.j = j;
            this.w = w;
        }
    }
}
