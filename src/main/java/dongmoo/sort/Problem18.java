package dongmoo.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            int insertPosition = i;
            int insertValue = A[i];
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > A[j]) {
                    insertPosition = j + 1;
                    break;
                }
                if (j == 0) {
                    insertPosition = 0;
                }
            }

            for (int j = i; j > insertPosition; j--) {
                A[j] = A[j - 1];
            }
            A[insertPosition] = insertValue;
        }


        int[] B = new int[N];
        B[0] = A[0];
        for (int i = 1; i < N; i++) {
            B[i] = A[i] + B[i - 1];
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += B[i];
        }
        System.out.println(sum);
    }
}
