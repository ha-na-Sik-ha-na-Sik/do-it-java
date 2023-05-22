package lunar.Graph;

import java.util.*;

public class Problem049 {
    static int A, B, C;
    static ArrayList<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        answer = new ArrayList<>();

        bfs();

        Collections.sort(answer);
        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }

    static class Bottle {
        int a;
        int b;
        int c;

        public Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static void bfs(){
        Queue<Bottle> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];

        queue.add(new Bottle(0, 0, C));
        while(!queue.isEmpty()){
            Bottle curr = queue.poll();
            if(visited[curr.a][curr.b][curr.c])
                continue;

            if(curr.a == 0){
                answer.add(curr.c);
            }
            visited[curr.a][curr.b][curr.c] = true;

            //B -> A
            if(curr.a + curr.b <= A){
                queue.add(new Bottle(curr.a + curr.b, 0, curr.c));
            } else {
                queue.add(new Bottle(A, curr.a + curr.b - A, curr.c));
            }

            //C -> A
            if(curr.a + curr.c <= A){
                queue.add(new Bottle(curr.a + curr.c, curr.b, 0));
            } else {
                queue.add(new Bottle(A, curr.b, curr.a + curr.c - A));
            }

            //A-> B
            if(curr.a + curr.b <= B){
                queue.add(new Bottle(0, curr.a + curr.b, curr.c));
            } else {
                queue.add(new Bottle(curr.a + curr.b - B, B, curr.c));
            }

            //C->B
            if (curr.b + curr.c <= B) {
                queue.add(new Bottle(curr.a, curr.b + curr.c, 0));
            } else {
                queue.add(new Bottle(curr.a, B, curr.b + curr.c - B));
            }

            //A->C
            if (curr.a + curr.c <= C) {
                queue.add(new Bottle(0, curr.b, curr.a + curr.c));
            } else {
                queue.add(new Bottle(curr.a + curr.c - C, curr.b, C));
            }

            //B->C
            if (curr.b + curr.c <= C) {
                queue.add(new Bottle(curr.a, 0, curr.b + curr.c));
            } else {
                queue.add(new Bottle(curr.a, curr.b + curr.c - C, C));
            }
        }
    }
}
