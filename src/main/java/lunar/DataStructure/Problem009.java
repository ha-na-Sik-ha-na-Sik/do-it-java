package lunar.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//슬라이딩 윈도우
public class Problem009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        char[] chars = str.toCharArray();
        int[] num = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int pt1 = 0, pt2 = pt1+p-1, count = 0, i = pt1;
        int[] tmp = new int[4];
        while(pt2 < s){
           if(chars[i] == 'A') tmp[0]++;
           else if(chars[i] == 'C') tmp[1]++;
           else if(chars[i] == 'G') tmp[2]++;
           else tmp[3]++;

           if(i == pt2) {
               if(Arrays.equals(num, tmp)) count++;
               tmp = new int[4];
               pt1++; pt2++; i = pt1;
           }
           else i++;
        }
        System.out.println(count);
    }
}
