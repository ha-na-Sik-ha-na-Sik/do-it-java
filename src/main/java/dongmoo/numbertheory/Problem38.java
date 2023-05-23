package dongmoo.numbertheory;

import java.util.List;
import java.util.Scanner;

public class Problem38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] input = s.split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        long[] nums = new long[10000001];

        for (int i = 2; i < nums.length; i++) {
            nums[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(nums.length); i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j < nums.length; j += i) {
                nums[j] = 0;
            }
        }

        int answer = 0;
        for (long num : nums) {
            if (num == 0) {
                continue;
            }
            int count = 2;

            while (Double.compare(Math.pow(num, count), (double) B) <= 0) {
                count++;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
