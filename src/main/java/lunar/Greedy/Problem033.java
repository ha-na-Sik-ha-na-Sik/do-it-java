package lunar.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        /*배열의 문제점: pre값이 cards 배열 내 남은 값보다 큰 경우를 무시한다.
        int[] cards = new int[n];
        for(int i = 0; i < n; i++){
            cards[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cards);
        int pre = cards[0];
        for(int i = 1; i < n; i++){
            pre += cards[i];
            sum += pre;
        }
        */

        //우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(pq.size() > 1){
            int tmp = pq.poll() + pq.poll();
            sum += tmp;
            pq.add(tmp);
        }

        System.out.println(sum);
    }
}
