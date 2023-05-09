package dongmoo.binarysearch;

import java.util.*;
import java.io.*;

public class Problem29 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N;
            int halfValue = 0;
            while (end - start > 0) {
                int halfIndex = (start + end) / 2;
                halfValue = A[halfIndex];
                if (halfValue == B[i]) {
                    break;
                } else if (end - start == 1) {
                    break;
                } else if (halfValue > B[i]) {
                    end = halfIndex;
                } else {
                    start = halfIndex;
                }
            }
            if (halfValue == B[i]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
