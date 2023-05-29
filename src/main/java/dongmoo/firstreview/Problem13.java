package dongmoo.firstreview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            int n = queue.peek();
            queue.add(n);
            queue.poll();

        }
        System.out.println(queue.peek());

    }
}
