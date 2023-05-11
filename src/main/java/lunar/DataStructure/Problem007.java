package lunar.DataStructure;

import java.io.*;
import java.util.*;

//투 포인터
public class Problem007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int pt1 = 1, pt2 = 1, count = 0, sum = 0;
        while(pt1 <= n && pt2 <= n){
            sum += pt2++;
            if(sum == m) {count++; pt1++; pt2 = pt1; sum = 0;}
            else if(sum > m) {pt1++; pt2 = pt1; sum = 0;}
        }

        System.out.println(count);
    }
}
