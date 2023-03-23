package bbakoon.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem11 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int n = 1;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            while (n <= cur) {
                stack.push(n++);
                answer.append("+\n");
            }
            if (stack.peek() != cur) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            answer.append("-\n");
        }
        System.out.println(answer);
    }
}
