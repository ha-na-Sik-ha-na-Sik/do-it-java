package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem34 {
    //수를 묶어서 최댓값 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(
                (i1, i2) -> Integer.compare(i2, i1)
        );
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                plusQueue.add(num);
            } else {
                minusQueue.add(num);
            }
        }

        int sum = 0;
        while (plusQueue.size() > 1) {
            int i1 = plusQueue.poll();
            int i2 = plusQueue.poll();

            if (i1 == 1 || i2 == 1) {
                sum += i1 + i2;
            } else {
                sum += i1 * i2;
            }
        }
        if (!plusQueue.isEmpty()) {
            while (!plusQueue.isEmpty()) {
                sum += plusQueue.poll();
            }
        }

        while (minusQueue.size() > 1) {
            int i1 = minusQueue.poll();
            int i2 = minusQueue.poll();

            sum += i1 * i2;
        }

        if (!minusQueue.isEmpty()) {
            while (!minusQueue.isEmpty()) {
                sum += minusQueue.poll();
            }
        }

        System.out.println(sum);
    }
}
