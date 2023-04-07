package lunar.Day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem028 {
    static ArrayList<Info>[] al;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        al = new ArrayList[n];
        for(int i = 0; i < n; i++){
            al[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int tmp = Integer.parseInt(st.nextToken());
            while(true){
                int edge = Integer.parseInt(st.nextToken());
                if(edge == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                al[tmp-1].add(new Info(edge-1, weight));
            }
        }

        distance = new int[n];
        visited = new boolean[n];
        BFS(0);
        int max = 0;
        for(int i = 1; i < n; i++){
            if(distance[max] < distance[i])
                max = i;
        }

        distance = new int[n];
        visited = new boolean[n];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[n-1]);
    }

    private static void BFS(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Info info: al[now]) {
                int e = info.edge;
                int w = info.weight;
                if(!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now] + w;
                }

            }
        }
    }
}

class Info {
    public int edge;
    public int weight;

    public Info(int edge, int weight) {
        this.edge = edge;
        this.weight = weight;
    }
}