package dongmoo.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        List<Integer> L = Arrays.stream(S.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int size = L.size();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int asInt = L.stream().mapToInt(x -> x)
                    .max().getAsInt();
            answer.append(asInt);
            L.remove(new Integer(asInt));
        }
        System.out.println(answer);
    }
}
