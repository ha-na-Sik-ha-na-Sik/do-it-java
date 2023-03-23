package lunar.Day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//스택
public class Problem011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        Stack<Integer> st = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp > cnt) {
                while(cnt < tmp) {
                    st.add(++cnt);
                    sb.append("+");
                }
                st.pop();
                sb.append("-");
            } else {
                if(st.peek() == tmp) {st.pop(); sb.append("-");}
                else {
                    sb.append('n');
                    System.out.print("NO");
                    break;
                }
            }
        }

        if((sb.charAt(sb.length()-1)) != 'n') {
            for (int i = 0; i < sb.length(); i++) {
                System.out.println(sb.charAt(i));
            }
        }
    }
}
