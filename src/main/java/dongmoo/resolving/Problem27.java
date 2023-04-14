package dongmoo.resolving;

import java.io.*;
import java.util.*;

public class Problem27 {

    static int[][] A;
    static boolean[][] visited;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N+2][M+2];
        visited = new boolean[N+2][M+2];

        for(int i=1;i<=N;i++) {
            String input = br.readLine();
            int n=1;
            for(String s: input.split("")) {
                A[i][n] = Integer.parseInt(s);
                visited[i][n] = false;
                n++;
            }
        }

        bfs(1,1);
        System.out.println(A[N][M]);
    }

    public static void bfs(int y, int x) {
        int[] start = new int[]{y,x};
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(start);

        while(!myQueue.isEmpty()) {
            int[] B = myQueue.poll();
            int y1 = B[0];
            int x1 = B[1];

            visited[y1][x1] = true;
            for(int i=0;i<4;i++) {
                int y2 = y1 + dy[i];
                int x2 = x1 + dx[i];
                if(!visited[y2][x2] && A[y2][x2]!=0){
                    A[y2][x2] = A[y1][x1]+1;
                    visited[y2][x2] = true;
                    myQueue.add(new int[]{y2,x2});
                }
            }
        }
    }
}
