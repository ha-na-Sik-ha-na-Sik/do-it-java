package lunar.Search;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem025 {
    static ArrayList<Integer>[] friends;
    static boolean visited[];
    static int depth;
    static boolean end = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());
        friends = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            friends[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e =  Integer.parseInt(st.nextToken());
            friends[s].add(e);
            friends[e].add(s);
        }

        for(int i = 0; i < n; i++){
            depth = 0;

            if(!visited[i]) {
                DFS(i);
            }

        }
        System.out.println(0);
    }

    static void DFS(int v){
        if(depth == 4){
            System.out.println(1);
            System.exit(0);
        }

        if(visited[v] || end) {
            end = true;
            return;
        }

        visited[v] = true;
        for(int i : friends[v]){
            if(visited[i] == false){
                depth++;
                DFS(i);
            }
        }
        end = false;
        depth = 0;
        visited[v] = false;
    }
}

//
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.ArrayList;
//        import java.util.StringTokenizer;
//
//public class Main {
//    static ArrayList<Integer>[] friends;
//    static boolean visited[];
//    static int depth;
//    static boolean end = false;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m =  Integer.parseInt(st.nextToken());
//        friends = new ArrayList[n];
//        visited = new boolean[n];
//        for(int i = 0; i < n; i++) {
//            friends[i] = new ArrayList<>();
//        }
//        for(int i = 0; i < m; i++){
//            st = new StringTokenizer(br.readLine());
//            int s = Integer.parseInt(st.nextToken());
//            int e =  Integer.parseInt(st.nextToken());
//            friends[s].add(e);
//            friends[e].add(s);
//        }
//
//        for(int i = 0; i < n; i++){
//            depth = 0;
//
//            if(!visited[i]) {
//                DFS(i, 0);
//            }
//
//        }
//        System.out.println(0);
//    }
//
//    static void DFS(int v, int depth){
//        if(depth == 4){
//            System.out.println(1);
//            System.exit(0);
//        }
//
//        visited[v] = true;
//        for(int i : friends[v]){
//            if(visited[i] == false){
//                DFS(i, depth + 1);
//            }
//        }
//        visited[v] = false;
//    }
//}
