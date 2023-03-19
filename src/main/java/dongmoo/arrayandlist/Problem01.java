package dongmoo.arrayandlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        String num = br.readLine();
        String[] nums = num.split("");
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(nums[i]);

        }

        System.out.println(sum);
    }
}
