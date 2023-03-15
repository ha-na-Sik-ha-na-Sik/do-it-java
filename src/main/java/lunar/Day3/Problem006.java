package lunar.Day3;

import java.io.*;

//투 포인터
public class Problem006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int pt1 = 1, pt2 = 1, count = 0, sum = 0;
        while(pt1 <= n && pt2 <= n){
                sum += pt2++;
                if(sum == n) {count++; pt1++; pt2 = pt1; sum = 0;}
                else if(sum > n) {pt1++; pt2 = pt1; sum = 0;}
        }

        System.out.println(count);
    }
}
