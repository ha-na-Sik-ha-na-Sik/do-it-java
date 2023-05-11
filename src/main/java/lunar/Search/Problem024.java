package lunar.Search;

import java.util.Scanner;

public class Problem024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DFS(2, 1, n);
        DFS(3, 1, n);
        DFS(5, 1, n);
        DFS(7, 1, n);
    }

    private static void DFS(int num, int digit, int n){
        if(digit == n){
            if(isPrime(num)) {
                System.out.println(num);
                return;
            }
        }

        for(int i = 1; i < 10; i++){
            if(i % 2 == 0){
                continue;
            }
            if(isPrime(num * 10 + i)) {
                DFS(num * 10 + i, digit+1, n);
            }
        }
    }

    private static boolean isPrime(int num){
        for(int i = 2; i <= num / 2; i++)
            if(num % i == 0)
                return false;
        return true;
    }
}
