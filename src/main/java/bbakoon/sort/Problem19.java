package bbakoon.sort;

import java.io.*;
import java.util.StringTokenizer;

public class Problem19 {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(0, N - 1, arr);
        System.out.println(arr[K - 1]);
    }

    public static void quickSort(int L, int R, int[] arr) {
        if (L < R) {
            int pivot = partition(L, R, arr);
            if (pivot > K - 1) {
                quickSort(L, pivot - 1, arr);
            } else if (pivot < K - 1) {
                quickSort(pivot + 1, R, arr);
            }
        }
    }

    public static int partition(int L, int R, int[] arr) {
        int M = (L + R) / 2;
        swap(L, M, arr);
        int pivot = arr[L];
        int i = L + 1;
        int j = R;
        while (true) {
            while (j >= L && pivot < arr[j]) j--;
            while (i <= R && pivot > arr[i]) i++;
            if (i < j) {
                swap(i++, j--, arr);
            } else {
                arr[L] = arr[j];
                arr[j] = pivot;
                return j;
            }
        }
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
