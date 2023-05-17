package lunar.Sorting;

import java.util.Arrays;
import java.util.Scanner;

//선택 정렬
public class Problem017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int[] num = new int[n.length()];
        for(int i = 0; i < n.length(); i++){
            num[i] = Integer.parseInt(String.valueOf(n.charAt(i)));
        }

        int idx = -1;
        for(int i = 0; i < n.length()-1; i++){
            int max = -1;
            for(int j = i; j < n.length(); j++){
                if(max < num[j]){
                    max = num[j];
                    idx = j;
                }
            }
            if(max != -1) {
                int tmp = num[i];
                num[i] = num[idx];
                num[idx] = tmp;
            }
        }

        for(int i = 0; i < n.length(); i++){
            System.out.print(num[i]);
        }
    }
}
