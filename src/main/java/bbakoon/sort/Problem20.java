package bbakoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem20 {

    static int N;
    static int[] arr, sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sorted = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (N == 1) {
            System.out.println(arr[0]);
            return;
        }
        mergeSort(0, N - 1);
        StringBuilder answer = new StringBuilder();
        for (int i : sorted) {
            answer.append(i).append("\n");
        }
        System.out.println(answer);
    }

    public static void mergeSort(int L, int R) {
        if (L == R) {
            return;
        }
        int M = (L + R) / 2;
        mergeSort(L, M);
        mergeSort(M + 1, R);
        merge(L, M, R);
    }

    public static void merge(int L, int M, int R) {
        int l = L;
        int r = M + 1;
        int idx = L;
        while (l <= M && r <= R) {
            if (arr[l] < arr[r]) {
                sorted[idx++] = arr[l++];
            } else {
                sorted[idx++] = arr[r++];
            }
        }
        if (l > M) {
            while (r <= R) {
                sorted[idx++] = arr[r++];
            }
        } else {
            while (l <= M) {
                sorted[idx++] = arr[l++];
            }
        }
        for (int i = L; i <= R; i++) {
            arr[i] = sorted[i];
        }
    }
}
