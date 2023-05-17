package lunar.DataStructure;

import java.io.*;

//배열
public class Problem001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            answer += num[i];
        }

        System.out.println(answer);
    }
}
