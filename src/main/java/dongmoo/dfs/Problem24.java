package dongmoo.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        dfs(2, 1, N);
        dfs(3, 1, N);
        dfs(5, 1, N);
        dfs(7, 1, N);


    }

    public static void dfs(int i, int j, int N) {
        if (j == N) {
            if (isPrime(i)) {
                System.out.println(i);
            }
            return;
        }
        for (int k = 1; k < 10; k+=2) {
            int i1 = i * 10 + k;
            if(isPrime(i1)) {
                dfs(i1, j + 1,N);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
