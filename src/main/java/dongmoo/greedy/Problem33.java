package dongmoo.greedy;

import java.util.*;

public class Problem33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        List<Integer> A = new ArrayList<>();
        int answer = 0;
        int seq = 0;

        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(sc.nextLine()));
        }

        if (N == 1) {
            answer = 0;
        } else if (N == 2) {
            answer = A.get(0) + A.get(1);
        } else {
            while (A.size() > 1) {
                Collections.sort(A);
                int i = A.get(0) + A.get(1);
                A.remove(0);
                A.remove(0);
                answer += i;
                A.add(i);
            }
        }

        System.out.println(answer);
    }
}
