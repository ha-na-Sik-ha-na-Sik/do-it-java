package dongmoo.resolving;

import java.util.*;
import java.io.*;

public class Problem24 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //한 자리수 중 소수인 수 : 2,3,5,7
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

    }

    public static void dfs(int n,int depth) {
        if (depth == N && isPrime(n)) {
            System.out.println(n);
            return;
        } else if (depth == N) {
            return;
        }

        for (int i = 1; i < 10; i += 2) {
            int temp = n * 10 + i;
            if (isPrime(temp)) {
                dfs(temp,depth+1);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
