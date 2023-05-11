package lunar.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이진탐색
public class Problem029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            if(find(num[i], arr)){
                System.out.println(1);
            } else{
                System.out.println(0);
            }
        }
    }

    static public boolean find(int k, int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(end >= start){
            int mid = (start + end) / 2;

            if(arr[mid] == k)
                return true;
            else if(arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
