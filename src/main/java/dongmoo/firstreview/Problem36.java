package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem36 {
	// 최솟값을 만드는 괄호 배치 찾기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();

		int sum = 0;
		int startIndex = 0;
		boolean minus = false;

		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (!Character.isDigit(ch)) {
				if (!minus) {
					sum += Integer.parseInt(S.substring(startIndex, i));
					startIndex = i;
					if (ch == '-') {
						minus = true;
					}
				} else {
					int now = Integer.parseInt(S.substring(startIndex, i));
					startIndex = i;
					if (now >= 0) {
						sum -= now;
					} else {
						sum += now;
					}
				}
			}
		}
		int i = Integer.parseInt(S.substring(startIndex));

		if (minus) {
			if (i > 0) {
				sum -= i;
			} else {
				sum += i;
			}
		} else {
			if (i > 0) {
				sum += i;
			} else {
				sum -= i;
			}
		}
		System.out.println(sum);
	}
}
