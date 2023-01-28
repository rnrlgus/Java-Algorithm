package baekjoon.ds1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(bf.readLine());
        String[] tmp = {};
        int last = 0;

        for (int i = 0; i < n; ++i) {
            tmp = bf.readLine().split(" ");

            if (tmp[0].equals("push")) {
                queue.add(Integer.parseInt(tmp[1]));
                last = Integer.parseInt(tmp[1]);
            }

            if (tmp[0].equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            }

            if (tmp[0].equals("size")) {
                sb.append(queue.size() + "\n");
            }

            if (tmp[0].equals("empty")) {
                if (queue.isEmpty()){
                    sb.append(1 + "\n");
                } else sb.append(0 + "\n");
            }

            if (tmp[0].equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1 + "\n");
                } else sb.append(queue.peek() + "\n");
            }

            if (tmp[0].equals("back")) {
                if (queue.isEmpty()) sb.append(-1 + "\n");
                else sb.append(last + "\n");
            }
        }
        bf.close();
        System.out.println(sb);
    }
}
