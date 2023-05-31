package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem12 {
    //오큰수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> mystack = new Stack<>();
        mystack.push(0);

        for (int i = 1; i < N; i++) {
            while (!mystack.isEmpty() && A[mystack.peek()] < A[i]) {
                answer[mystack.pop()] = A[i];
            }
            mystack.push(i);
        }

        for (int integer : mystack) {
            answer[integer] = -1;
        }

        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
