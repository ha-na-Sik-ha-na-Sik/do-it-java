package lunar.Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//그리디 알고리즘
public class Problem032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int[] price = new int[n];
        for(int i = 0; i < n; i++){
            price[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i = n - 1; i >= 0; i--){
            if(price[i] <= goal){
                cnt += goal / price[i];
                goal = goal % price[i];
            }
            if(goal == 0){
                break;
            }
        }

        System.out.println(cnt);
    }
}
