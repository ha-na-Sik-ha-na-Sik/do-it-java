package dongmoo.arrayandlist.twopointer;

import java.util.Scanner;

public class Problem06 {
    //연속된 자연수의 합 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int lp = 1;
        int rp = 1;
        int sum = 1;
        int cnt = 1;
        while(lp < N) {
            if (sum == N) {
                cnt++;
                rp++;
                sum += rp;
            } else if (sum > N) {
                sum -= lp;
                lp++;
            } else {
                rp++;
                sum += rp;
            }
        }

        System.out.println(cnt);
    }


}
