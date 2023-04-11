package bbakoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem28 {

    static int V;
    static ArrayList<Node>[] adj;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        adj = new ArrayList[V + 1];
        distance = new int[V + 1];
        Arrays.fill(distance, -1);
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            adj[u] = new ArrayList<>();
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                int w = Integer.parseInt(st.nextToken());
                adj[u].add(new Node(v, w));
            }
        }
        bfs(1);
        int max = 0;
        int idx = 0;
        for (int i = 1; i <= V; i++) {
            if (max < distance[i]) {
                idx = i;
                max = distance[i];
            }
        }
        Arrays.fill(distance, -1);
        bfs(idx);
        Arrays.sort(distance);
        System.out.println(distance[V]);
    }

    public static void bfs(int v) {
        distance[v] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(v, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : adj[cur.v]) {
                if (distance[next.v] == -1) {
                    distance[next.v] = cur.w + next.w;
                    queue.add(new Node(next.v, distance[next.v]));
                }
            }
        }
    }

    public static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
