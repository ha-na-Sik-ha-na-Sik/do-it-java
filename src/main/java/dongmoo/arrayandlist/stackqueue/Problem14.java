package dongmoo.arrayandlist.stackqueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem14 {
    //절대값 힙 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> myPriorityQueue = new PriorityQueue<>((o1,o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if (first == second) {
                return o1 > o2 ? 1 : -1;
            } else {
                return first - second;
            }
        });


        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                if (myPriorityQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(myPriorityQueue.poll());
                }
            } else {
                myPriorityQueue.add(input);
            }
        }
    }
}
