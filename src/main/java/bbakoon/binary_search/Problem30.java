package bbakoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem30 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int end = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
        }
        System.out.println(binarySearch(end));
    }

    public static int binarySearch(int end) {
        int S = 0;
        int E = end;
        int result = 0;
        while (S <= E) {
            int M = (S + E) / 2;
            if (check(M)) {
                result = M;
                E = M - 1;
            } else {
                S = M + 1;
            }
        }
        return result;
    }

    public static boolean check(int size) {
        int n = 1;
        int cur = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > size) return false;
            if (cur + arr[i] > size) {
                n++;
                cur = arr[i];
                if (n > M) {
                    return false;
                }
            } else {
                cur += arr[i];
            }
        }
        return true;
    }
}
