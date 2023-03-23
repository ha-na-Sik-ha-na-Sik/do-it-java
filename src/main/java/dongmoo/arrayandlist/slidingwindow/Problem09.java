package dongmoo.arrayandlist.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem09 {
//DNA 비밀번호

    static int[] checkArr;
    static int[] myArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String DNA = br.readLine();
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        checkSecret = 0;
        checkArr = new int[4];
        myArr = new int[4];

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        char[] A = DNA.toCharArray();
        for (int i = 0; i < P; i++) {
            add(A[i]);
        }

        if (checkSecret == 4) {
            cnt++;
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            remove(A[j]);
            add(A[i]);
            if (checkSecret == 4) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void add(char c) {
        if (c=='A') {
            myArr[0]++;
            if (myArr[0] == checkArr[0]) {
                checkSecret++;
            }
        } else if (c=='C') {
            myArr[1]++;
            if (myArr[1] == checkArr[1]) {
                checkSecret++;
            }
        } else if (c=='G') {
            myArr[2]++;
            if (myArr[2] == checkArr[2]) {
                checkSecret++;
            }
        } else if (c=='T') {
            myArr[3]++;
            if (myArr[3] == checkArr[3]) {
                checkSecret++;
            }
        }
    }

    public static void remove(char c) {
        if (c=='A') {
            if (myArr[0] == checkArr[0]) {
                checkSecret--;
            }
            myArr[0]--;
        } else if (c=='C') {
            if (myArr[1] == checkArr[1]) {
                checkSecret--;
            }
            myArr[1]--;
        } else if (c=='G') {
            if (myArr[2] == checkArr[2]) {
                checkSecret--;
            }
            myArr[2]--;
        } else if (c=='T') {
            if (myArr[3] == checkArr[3]) {
                checkSecret--;
            }
            myArr[3]--;
        }
    }

}
// 같을 때를 기준으로 계산 -> 한번만 계산한다
