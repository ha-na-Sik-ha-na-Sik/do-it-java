package lunar.Sorting;

import java.io.*;

//병합 정렬
public class Problem020 {
    static int[] num;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        tmp = new int[n];
        for(int i = 0; i < n; i++){
            num[i] =Integer.parseInt(br.readLine());
        }
        mergeSort(0, n-1);
        for(int i = 0; i < n; i++){
            bw.write(String.valueOf(num[i]) + '\n');
        }
        bw.flush();
        bw.close();
    }
    public static void mergeSort(int s, int e){
        if(e-s < 1) return ;
        int m = s + (e-s) / 2;
        mergeSort(s, m);
        mergeSort(m+1, e);
        for(int i = s; i <= e; i++){
            tmp[i] = num[i];
        }

        int k = s;
        int pt1 = s, pt2 = m+1;
        while(pt1 <= m && pt2 <= e){
            if(tmp[pt1] > tmp[pt2]){
                num[k++] = tmp[pt2++];
            } else {
                num[k++] = tmp[pt1++];
            }
        }

        while(pt1 <= m){
            num[k++] = tmp[pt1++];
        }

        while(pt2 <= e){
            num[k++] = tmp[pt2++];
        }
    }
}
