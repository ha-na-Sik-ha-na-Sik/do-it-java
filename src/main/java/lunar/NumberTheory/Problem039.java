package lunar.NumberTheory;

import java.util.Scanner;

public class Problem039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String num = "";
        int[] arr = new int[10000001];

        for(int i = 2; i <= 10000000; i++){
            arr[i] = i;
        }

        for(int i = 2; i < Math.sqrt(10000000); i++){
            if(arr[i] == 0) continue;
            for(int j = i * 2; j <= 10000000; j+=i){
                arr[j] = 0;
            }
        }

        for(int i = n; i <= 10000000; i++){
            if(arr[i] != 0){
                boolean is = isPalindrome(arr[i]);
                if(is == true){
                    System.out.println(arr[i]);
                    break;
                }
            }
        }

    }

    private static boolean isPalindrome(int t){
        String num = String.valueOf(t);
        for(int j = 0; j < num.length()/2; j++){
            char f = num.charAt(j);
            char b = num.charAt(num.length()-1-j);
            if(f != b){
                return false;
            };
        }
        return true;
    }
}
