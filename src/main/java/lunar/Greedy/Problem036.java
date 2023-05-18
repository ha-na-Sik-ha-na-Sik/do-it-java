package lunar.Greedy;
import java.util.Scanner;

public class Problem036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();

        String[] values = expr.split("-|[+]");
        String[] operators = expr.split("[0-9]+");

        int answer = 0;
        int sum = 0;
        for(int i = operators.length-1; i >= 0; i--){
            sum += Integer.parseInt(values[i]);
            if(operators[i].equals("-")){
                answer -= sum;
                sum = 0;
            }

            if(i == 0){
                answer += sum;
            }
        }

        System.out.println(answer);
    }
}
