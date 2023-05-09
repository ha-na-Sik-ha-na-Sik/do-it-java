package bbakoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem06 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 1;
        int L = 1;
        int R = 2;
        int sum = 3;
        while (R < N) {
            if (sum == N) {
                answer++;
                sum += ++R;
            } else if (sum > N) {
                sum -= L++;
            } else {
                sum += ++R;
            }
        }
        System.out.println(answer);
    }
}
