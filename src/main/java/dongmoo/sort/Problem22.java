package dongmoo.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);

        String[] A = new String[N];

        for (int i = 0; i < N; i++) {
            String format = String.format("%05d", Integer.parseInt(br.readLine()));
            A[i] = format;
        }


        List<Queue<String>> myQueue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myQueue.add(new LinkedList<>());
        }

        for (int i = 4; i >= 0; i--) {
            for (int j = 0; j < A.length; j++) {
                myQueue.get(A[j].charAt(i)-'0').add(A[j]);
            }
            int n = 0;
            for (int j = 0; j < 10; j++) {
                if (myQueue.get(j).isEmpty()) {
                    continue;
                }
                while (!myQueue.get(j).isEmpty()) {
                    A[n++] = myQueue.get(j).poll();
                }
            }
        }
        for (String s : A) {
            System.out.println(Integer.parseInt(s));
        }

    }
}
