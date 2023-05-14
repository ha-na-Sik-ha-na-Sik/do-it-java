package dongmoo.greedy;

import java.util.Scanner;

public class Problem36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        boolean minus = false;
        int answer = 0;
        int startIndex = 0;

        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() - 1) {
                int n = Integer.parseInt(s.substring(startIndex, i + 1));
                if (minus) {
                    answer -= n;
                } else {
                    answer += n;
                }
                System.out.println(answer);
                return;
            }

            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                int n = Integer.parseInt(s.substring(startIndex, i));
                if (minus) {
                    answer -= n;
                    startIndex = i + 1;
                } else {
                    if (s.charAt(i) == '-') {
                        minus = true;
                    }
                    answer += n;
                    startIndex = i + 1;
                }
            }
        }
    }
}
