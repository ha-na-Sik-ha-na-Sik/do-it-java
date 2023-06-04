package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem33 {
    // 카드 정렬하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            myQueue.add(num);
        }

        int sum = 0;
        while (myQueue.size() > 1) {
            int first = myQueue.poll();
            int second = myQueue.poll();

            int shuffle = first + second;
            sum += shuffle;
            myQueue.add(shuffle);
        }

        System.out.println(sum);
    }
}
