package lunar.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//너비 우선 탐색
public class Problem027 {
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int n, m, depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        maze = new int[n][m];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++)
                maze[i][j] = Integer.parseInt(line.substring(j, j+1));
        }
        BFS(0, 0);
        System.out.println(maze[n-1][m-1]);

    }

    private static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            visited[i][j] = true;
            for(int k = 0; k < 4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < n && y < m){
                    if(maze[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        maze[x][y] = maze[now[0]][now[1]] + 1;
                        queue.add(new int[] {x, y});
                    }
                }

            }
        }
    }
}
