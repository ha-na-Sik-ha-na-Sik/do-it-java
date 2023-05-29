package dongmoo.firstreview;

import java.util.Scanner;

public class Problem24 {
    static int N;
    static int[] nums = {1, 3, 5, 7, 9};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
    }

    public static void dfs(int num, int depth) {
        if (!isPrime(num)) {
            return;
        }
        if (depth == N) {
            System.out.println(num);
            return;
        }
        for (int n : nums) {
            dfs(num * 10 + n, depth + 1);
        }
    }

    public static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
