package lunar.Day6;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        RadixSort(num, 5);

        for (int i = 0; i < n; i++) {
            bw.write(num[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void RadixSort(int[] num, int size) {
        int digit = 1, cnt = 0;
        int[] result = new int[num.length];

        while(cnt != size){
            int[] bucket = new int[10];
            for(int i = 0; i < num.length; i++){
                bucket[(num[i] / digit) % 10]++;
            }

            for(int i = 1; i < 10; i++){
                bucket[i] += bucket[i-1];
            }

            for(int i = num.length-1; i >= 0; i--){
                result[bucket[num[i] / digit % 10] - 1] = num[i];
                bucket[(num[i] / digit) % 10]--;
            }

            for(int i = 0; i < num.length; i++){
                num[i] = result[i];
            }
            digit *= 10;
            cnt++;
        }
    }

    /*
    큐로 구현하면 메모리 초과
    public static void RadixSort(int[] num, int size) {
        Queue<Integer>[] bucket = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            bucket[i] = new LinkedList<>();
        }

        int digit = 1, cnt = 0;
        while (cnt != size) {
            for (int i = 0; i < num.length; i++) {
                bucket[(num[i] / digit) % 10].add(num[i]);
            }

            for (int i = 0, j = 0; i < 10; i++) {
                while (!bucket[i].isEmpty()) {
                    num[j++] = bucket[i].poll();
                }
            }

            digit *= 10;
            cnt++;
        }
    }
     */
}
