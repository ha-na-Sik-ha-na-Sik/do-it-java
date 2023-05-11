package lunar.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import static java.util.Collections.sort;

public class Problem034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        int zero = 0;
        int one = 0;

        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp > 1){
                positive.add(tmp);
            } else if(tmp == 1){
                one++;
            } else if(tmp == 0) {
                zero++;
            } else {
                negative.add(tmp);
            }
        }

        sort(positive);
        sort(negative);

        int sum = one;
        int stop = 0;
        if(positive.size() % 2 != 0){
            stop = 1;
            sum += positive.get(0);
        }

        for(int i = positive.size()-1; i > stop; i--) {
            sum += positive.get(i) * positive.get(i-1);
            i--;
        }

        stop = negative.size()-1;
        if(negative.size() % 2 != 0){
            if(zero <= 0){
                sum += negative.get(stop);
            }
            stop -= 1;
        }

        for(int i = 0; i < stop; i++){
            sum += negative.get(i) * negative.get(i+1);
            i++;
        }

        System.out.println(sum);
    }
}
