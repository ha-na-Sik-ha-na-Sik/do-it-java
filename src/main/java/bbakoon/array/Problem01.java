package bbakoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        int answer = 0;
        for (char c : input) {
            answer += c - '0';
        }
        System.out.println(answer);
    }
}
