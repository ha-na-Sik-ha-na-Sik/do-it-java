package lunar.Day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//삽입정렬
public class Problem018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(num[i] < num[j]){
                    int tmp = num[i];
                    for(int k = i-1; k >= j; k--){
                        num[k+1] = num[k];
                    }
                    num[j] = tmp;
                }
            }
        }

        int sum = 0, cnt = n;
        for(int i = 0; i < n; i++){
            sum += num[i] * cnt--;
        }

        System.out.print(sum);
    }
}
