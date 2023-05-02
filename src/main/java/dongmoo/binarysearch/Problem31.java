package dongmoo.binarysearch;

import java.util.Scanner;

public class Problem31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());

        int l = 1;
        int r = k;
        int result = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
                result = mid;
            }
        }
        System.out.println(result);

    }
}
