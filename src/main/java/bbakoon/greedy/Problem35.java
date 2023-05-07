import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem35
{

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Room> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Room(s, e));

        }
        int answer = 1;
        int time = pq.poll().e;
        while (!pq.isEmpty()) {
            Room room = pq.poll();
            if (room.s < time) continue;
            answer++;
            time = room.e;
        }
        System.out.println(answer);
    }

    public static class Room implements Comparable<Room> {
        int s;
        int e;

        public Room(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Room o) {
            if (this.e == o.e) {
                return this.s - o.s;
            }
            return this.e - o.e;
        }
    }
}