package dongmoo.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem23 {
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> myStack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.get(start).add(end);
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            List<Integer> integers = map.get(i);
            for (int j = 0; j < integers.size(); j++) {
                int n = integers.get(j);
                if (visited[n]) {
                    continue;
                }
                myStack.push(n);
            }


        }

    }
}
