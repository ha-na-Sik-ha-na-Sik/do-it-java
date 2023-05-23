package bbakoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem49 {

    static int a, b, c;
    static ArrayList<Integer> answer = new ArrayList<>();
    static int[] send = {0, 0, 1, 1, 2, 2};
    static int[] rec = {1, 2, 0, 2, 0, 1};
    static int[] space = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        space[0] = a;
        space[1] = b;
        space[2] = c;
        bfs();
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (Integer i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        boolean[][] visited = new boolean[a + 1][b + 1];
        Queue<Water> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new Water(0, 0));
        while (!queue.isEmpty()) {
            Water cur = queue.poll();
            if (cur.a == 0) {
                answer.add(c - cur.a - cur.b);
            }
            for (int i = 0; i < 6; i++) {
                int[] w = new int[]{cur.a, cur.b, c - cur.a - cur.b};
                if (w[send[i]] == 0) continue;
                w[rec[i]] += w[send[i]];
                w[send[i]] = 0;
                if (w[rec[i]] > space[rec[i]]) {
                    w[send[i]] = w[rec[i]] - space[rec[i]];
                    w[rec[i]] = space[rec[i]];
                }
                if (!visited[w[0]][w[1]]) {
                    visited[w[0]][w[1]] = true;
                    queue.add(new Water(w[0], w[1]));
                }
            }
        }
    }

    static class Water {
        int a;
        int b;

        public Water(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
