package lunar.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//버블 정렬
public class Problem015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i = n-1; i > 0; i--){
            for(int j = 0; j < i; j++) {
                if (num[j] > num[j + 1]){
                    int tmp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = tmp;
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println(num[i]);
        }
    }
}
