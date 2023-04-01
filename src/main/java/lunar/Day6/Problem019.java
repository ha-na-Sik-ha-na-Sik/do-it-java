package lunar.Day6;

import java.io.*;
import java.util.StringTokenizer;

//시간 초과
//퀵 정럴
public class Problem019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, n - 1, k-1, num);
        bw.write(String.valueOf(num[k-1]));
        bw.flush();
        bw.close();
    }

    public static void quickSort(int l, int r, int k, int[] num) {
        int pivot = partition(l, r, num);
        if (pivot == k) {
            return;
        } else if (k < pivot) {
            quickSort(l, pivot - 1, k, num);
        } else {
            quickSort(pivot + 1, r, k, num);
        }
    }

    public static int partition(int l, int r, int[] num){
        int p = (l+r)/2;
        swap(p, l, num);
        p = num[l];

        int i = l, j = r;
        while(i < j){
            while(p < num[j]) j--;
            while(i < j && p >= num[i]) i++;
            swap(i, j, num);
        }

        num[l] = num[i];
        num[i] = p;
        return i;
    }

    public static void swap(int i, int j, int[] num){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
