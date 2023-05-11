package lunar.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//투 포인터
public class Problem008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int i = 2, pt1 = 0, pt2 = pt1+1, tmp = 0, sum = 0, count = 0;
        while(i < n){
            tmp = num[i++];
            while(pt1 < i-2) {
                sum = num[pt1];
                if (sum + num[pt2] < tmp) { pt2++; }
                else if (sum + num[pt2] == tmp) {
                   pt1 = 0; pt2 = pt1+1; count++; break;
                } else { pt1++; pt2 = pt1+1; }
            }
            pt1 = 0; pt2 = pt1+1;
        }
        System.out.println(count);
    }
}
