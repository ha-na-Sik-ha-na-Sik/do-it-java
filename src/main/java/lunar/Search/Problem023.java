package lunar.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    Boolean은 null로 초기화, boolean은 false로 초기화
 */

//깊이 우선 탐색
public class Problem023 {
    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());
        A = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e =  Integer.parseInt(st.nextToken());
            A[s-1].add(e-1);
            A[e-1].add(s-1);
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]) {
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }

    static void DFS(int v){
        if(visited[v])
            return;
        visited[v] = true;
        for(int i : A[v]){
            if(visited[i] == false)
                DFS(i);
        }
    }
}
