package lunar.Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//시간초과
public class Problem048 {
    static ArrayList<Integer>[] arr;
    static int visited[];
    static int[] put = {1, 2};
    static boolean check = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr = new ArrayList[n+1];
            for(int l = 0; l <= n; l++){
                arr[l] = new ArrayList<>();
            }
            for(int j = 0; j < e; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                arr[start].add(end);
            }
            visited = new int[n+1];
            dfs(1);
            if(check == false) {
                bw.write("NO");
                bw.newLine();
            }
            else {
                bw.write("YES");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int k){
        visited[k] = put[k%2];

        for(int i: arr[k]){
            if(visited[i] != 0 && visited[i] == visited[k]){
                check = false;
                break;
            };
            dfs(i);
        }
    }
}
