import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem34
{

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (pq.isEmpty() || cur == 1) {
                answer += cur;
            } else if (cur == 0) {
                if (pq.size() % 2 != 0) {
                    pq.poll();
                }
            } else if (cur > 1) {
                if (pq.peek() <= 1) {
                    answer += cur;
                } else {
                    answer += cur * pq.poll();
                }
            } else {
                if (pq.size() % 2 != 0) {
                    answer += cur * pq.poll();
                } else {
                    answer += cur;
                }
            }
        }
        System.out.println(answer);
    }
}