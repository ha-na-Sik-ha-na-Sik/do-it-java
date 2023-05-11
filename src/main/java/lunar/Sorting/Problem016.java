package lunar.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];
        int[] sorted = new int[n+1];

        for(int i = 1; i < n+1; i++){
            num[i] = Integer.parseInt(br.readLine());
            sorted[i] = num[i];
        }

        Arrays.sort(sorted);

        int max = 0;
        for(int i = 1; i < n+1; i++){
            // * indexOf() 는 문자열을 인자로 넘겨주어야 함. int 값을 넣어도 해당 아스키 값으로 변환하여 사용함
            int idx = Arrays.asList(num).indexOf(sorted[i]-'0');
            max = Math.max(max, idx-i);
        }

        System.out.println(max+1);
    }
}
