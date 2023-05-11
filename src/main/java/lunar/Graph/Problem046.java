package lunar.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem046 {
    static int n;
    static int m;
    static int k;
    static int s;
    static int[] distances;
    static ArrayList<Edge>[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시 수
        m = Integer.parseInt(st.nextToken()); // 도로 수
        k = Integer.parseInt(st.nextToken()); // 최단 거리
        s = Integer.parseInt(st.nextToken()); // 출발 도시
        distances = new int[n+1];
        edgeList = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            edgeList[i] = new ArrayList<>();
            distances[i] = Integer.MAX_VALUE; // 거리 최댓값으로 초기화하는 것 잊지 않기
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            edgeList[s].add(new Edge(e, 1));
        }

        distances[s] = 0;
        Dijkstra();
        int answer = 0;
        for (int i=1; i < distances.length; i++){
            //System.out.println(distances[i]);
            if (distances[i] == k) {
                System.out.println(i);
                answer++;
            }
        }
        if(answer == 0) System.out.println(-1);
    }

    static void Dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s, 0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int v = e.v;
            int c = e.c;
            if(distances[v] < c){
                continue;
            }
            for(int i = 0; i < edgeList[v].size(); i++){
                int v2 = edgeList[v].get(i).v;
                int c2 = edgeList[v].get(i).c + c;
                if(distances[v2] > c2){
                    distances[v2] = c2;
                    pq.add(new Edge(v2, c2));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        int v;
        int c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return c - o.c;
        }
    }
}
