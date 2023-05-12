package lunar.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem047 {
    private static ArrayList<Integer>[] arr;
    private static boolean visited[];
    private static int max_depth[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }

        max_depth = new int[n+1];
        for(int i = 1; i <= n; i++){
            visited = new boolean[n+1];
            visited[i] = true;
            max_depth[i]++;
            DFS(i);
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max, max_depth[i]);
        }

        for(int i = 1; i <= n; i++){
            if(max_depth[i] == max){
                System.out.print(i + " ");
            }
        }

    }

    private static void DFS(int i){
        //return 선언할 필요가 없는 점 고려
        for(int v: arr[i]) {
            if (!visited[v]) {
                visited[v] = true;
                DFS(v);
                max_depth[v]++;
            }
        }
    }
}
