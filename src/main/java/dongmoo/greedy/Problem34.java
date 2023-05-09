package dongmoo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        List<Integer> minusNums = new ArrayList<>();
        List<Integer> plusNums = new ArrayList<>();
        boolean containZero = false;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(sc.nextLine());
            if (num > 0) {
                plusNums.add(num);
                continue;
            }
            if (num == 0) {
                containZero = true;
                continue;
            }
            minusNums.add(num);
        }

        minusNums.sort(Collections.reverseOrder());
        plusNums.sort(Collections.reverseOrder());

        int answer = 0;

        if (containZero) {
            if (minusNums.size() % 2 == 0) {
                minusNums.add(0, 0);
            } else {
                minusNums.add(minusNums.size(), 0);
            }
        }

        for (int i = 0; i < minusNums.size() - 1; i += 2) {
            answer += minusNums.get(i) * minusNums.get(i + 1);
        }

        for (int i = 0; i < plusNums.size() - 1; i += 2) {
            answer += plusNums.get(i) * plusNums.get(i + 1);
        }

        if (plusNums.size() % 2 != 0) {
            answer += plusNums.get(plusNums.size() - 1);
        }
        if (minusNums.size() % 2 != 0) {
            answer += minusNums.get(minusNums.size() - 1);
        }

        System.out.println(answer);
    }
}
