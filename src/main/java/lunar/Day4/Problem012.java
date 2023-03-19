package lunar.Day4;

import java.io.*;
import java.util.*;

//스택(, 큐)
public class Problem012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        stack.add(0);
        for(int i = 1; i < n; i++){
            if(num[i-1] <= num[i]){
                while(!stack.isEmpty() && num[stack.peek()] < num[i]) {
                    result[stack.pop()] = num[i];
                }
            };
            stack.add(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++) {
            if(result[i] == 0) result[i] = -1;
            bw.write(String.valueOf(result[i]));
            bw.write(" ");
        }
        bw.flush();
        bw.close();

        /*
        시간 초과
        for(int i = 0; i < n-1; i++){
            int a = queue.poll();
            Iterator iter = queue.iterator();
            while(iter.hasNext()) {
                int b = Integer.parseInt(iter.next().toString());
                if (a < b) {num[i] = b; break;}
                else num[i] = -1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(result[i] == 0) result[i] = -1;
            System.out.print(result[i] + " ");
        }
         */
    }
}
