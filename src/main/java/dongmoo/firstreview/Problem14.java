package dongmoo.firstreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem14 {
    //절대값 힙 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Abs> pqueue = new PriorityQueue<>(
                (abs1,abs2) -> {
                    if (abs1.abs == abs2.abs) {
                        return Integer.compare(abs1.value, abs2.value);
                    } else {
                        return Integer.compare(abs1.abs, abs2.abs);
                    }
                }
        );
        for (int i = 0; i < N; i++) {
            int j = Integer.parseInt(br.readLine());
            if (j == 0) {
                if (pqueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pqueue.poll().value);
                }
            } else {
                Abs abs = new Abs(j);
                pqueue.add(abs);
            }
        }
    }

    static class Abs {
        int value;
        int abs;

        public Abs(int value) {
            this.value = value;
            this.abs = Math.abs(value);
        }

    }
}
