package lunar.DataStructure;

import java.io.*;
import java.util.*;

//배열
public class Problem002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] num = new double[n];
        for(int i = 0; i < n; i++){
            num[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(num);
        double answer = 0;
        for(int i = 0; i < n; i++){
            answer += num[i]/num[n-1]*100;
        }

        System.out.println(answer/n);
    }
}
