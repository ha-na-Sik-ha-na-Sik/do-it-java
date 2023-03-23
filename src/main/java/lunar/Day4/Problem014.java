package lunar.Day4;

import java.io.*;
import java.util.PriorityQueue;

public class Problem014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            int first = Math.abs(x);
            int second = Math.abs(y);
            if(first == second)
                return x - y;
            return first - second;
        });

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                pq.add(num);
            } else {
                if (!pq.isEmpty())
                    System.out.println(pq.poll());
                else
                    System.out.println(0);
            }
        }
    }
}
