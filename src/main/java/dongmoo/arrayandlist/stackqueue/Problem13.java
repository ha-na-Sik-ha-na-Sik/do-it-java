package dongmoo.arrayandlist.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem13 {
    //카드게임
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            myQueue.add(i);
        }

        while (myQueue.size() > 1) {
            myQueue.poll();
            myQueue.add(myQueue.peek());
            myQueue.poll();
        }
        System.out.println(myQueue.poll());
    }

}
