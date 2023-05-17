package lunar.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//너비 우선 탐색
public class Problem026 {
    static ArrayList<Integer>[] nodes;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes[s-1].add(e-1);
            nodes[e-1].add(s-1);
        }

        for(int i = 0; i < n; i++){
            Collections.sort(nodes[i]);
        }

        visited = new boolean[n];
        DFS(k-1);
        System.out.println();
        visited = new boolean[n];
        BFS(k-1);

    }

    private static void DFS(int v){
        if(visited[v])
            return;
        System.out.print(v+1 + " ");
        visited[v] = true;
        for(int i : nodes[v]){
            DFS(i);
        }
    }

    private static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+1 +" ");
            for(int i : nodes[now]){
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
