package dongmoo.firstreview;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Problem11 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(sc.nextLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(sc.nextLine());
        }

        Stack<Integer> mystack = new Stack<>();
        int start = 1;
        for (int i = 0; i < N; i++) {
            int now = A[i];
            if (now >= start) {
                while (now >= start) {
                    mystack.push(start++);
                    sb.append("+" + "\n");
                }
                mystack.pop();
                sb.append("-" + "\n");
            } else {
                int temp = mystack.pop();
                if (temp > now) {
                    System.out.println("NO");
                    return;
                }
                sb.append("-" + "\n");
            }
        }
        System.out.println(sb);
    }
}
