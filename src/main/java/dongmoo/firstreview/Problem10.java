package dongmoo.firstreview;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem10 {
    //최솟값 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int lp = 0;
        int rp = 0;

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

            //가장 뒤 node 의 값이 현재의 값보다 큰 경우 가장 뒤 node 삭제
            while (!mydeque.isEmpty() && mydeque.getLast().value > A[i]) {
                mydeque.removeLast();
            }
            Node node = new Node(i, A[i]);
            mydeque.addLast(node);

            // 범위 밖으로 밀려난 값은 덱에서 제외
            // i 의 값은 현재 윈도우의 가장 끝 인덱스이므로 윈도우의 시작 인덱스는 i-L+1
            if (mydeque.getFirst().index <= i - L) {
                mydeque.removeFirst();
            }

            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        public int index;
        public int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
