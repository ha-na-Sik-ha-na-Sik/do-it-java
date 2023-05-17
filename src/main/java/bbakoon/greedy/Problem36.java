package bbakoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem36 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("-");
        int answer = 0;
        for (int i = 0; i < split.length; i++) {
            int sum = 0;
            String[] s = split[i].split("[+]");
            for (String value : s) {
                sum += Integer.parseInt(value);
            }
            if (i == 0) {
                answer += sum;
            } else {
                answer -= sum;
            }
        }
        System.out.println(answer);
    }
}