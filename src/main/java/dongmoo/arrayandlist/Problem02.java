package dongmoo.arrayandlist;

import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int max = scores[0];
        for (int score : scores) {
            max = Math.max(score,max);
        }

        double sum = 0;
        for (int score : scores) {
            sum += ((double) score / max) * 100;
        }

        System.out.println(sum/n);
    }
}
