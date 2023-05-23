package lunar.NumberTheory;

import java.util.Scanner;

//시간초과
public class Problem038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long[] num = new long[(int)(b+1)];
        for(int i = 2; i < b+1; i++){
            num[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(b); i++){
            if (num[i] == 0){
                continue;
            }
            for(int j = i+i; j < b+1; j+=i){
                num[j] = 0;
            }
        }

        int answer = 0;
        for(int i = 2; i < b+1; i++){
            long tmp = num[i]*num[i];
            if(num[i] != 0){
                while(tmp <= b){
                    if(tmp < a){
                        continue;
                    }
                    answer++;
                    tmp *= num[i];
                }
            }
        }
        System.out.println(answer);
    }
}
