package baekjoon.ds1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


class Ballon {
    int idx;
    int val;

    Ballon(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}
public class B2346 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<Ballon> deque = new ArrayDeque<>();


        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; ++i) {
            deque.offer(new Ballon(i+1, Integer.parseInt(st.nextToken())));
        }

        while (!deque.isEmpty()) {
            int num = deque.getFirst().idx;
            int val = deque.poll().val;
            System.out.print(num + " ");

            if (deque.isEmpty()) break;
            if (val > 0) {
                for (int i = 1; i < val; ++i) {
                    deque.offer(deque.poll());
                }
            } else {
                for (int i = 0; i < -val; ++i) {
                    deque.offerFirst(deque.pollLast());
                }
            }

        }
    }
}