package bbakoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        for (int i = 0; i < arr.length; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[max]) max = j;
            }
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
        StringBuilder answer = new StringBuilder();
        for (int i : arr) {
            answer.append(i);
        }
        System.out.println(answer);
    }
}
