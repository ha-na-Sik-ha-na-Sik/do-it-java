package lunar.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem037 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n+1];

        for(int i = 2; i <= n; i++){
            nums[i] = i;
        }


        for(int i = 2; i < n; i++){
            if(nums[i] == 0){
                continue;
            }
            for(int j = i+i; j <= n; j+=i){
                nums[j] = 0;
            }
        }


        for(int i = m; i <= n; i++){
            if(nums[i] != 0){
                System.out.println(nums[i]);
            }
        }
    }
}
