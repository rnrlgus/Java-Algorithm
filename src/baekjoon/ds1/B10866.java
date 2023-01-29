package baekjoon.ds1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class B10866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i) {
            String[] str = br.readLine().split(" ");

            if (str[0].equals("push_front")) {
                deque.addFirst(Integer.parseInt(str[1]));
            } else if (str[0].equals("push_back")) {
                deque.addLast(Integer.parseInt(str[1]));
            } else if (str[0].equals("pop_front")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollFirst());
            } else if (str[0].equals("pop_back")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollLast());
            } else if (str[0].equals("size")) {
                System.out.println(deque.size());
            } else if (str[0].equals("empty")) {
                if (deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (str[0].equals("front")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.getFirst());
            } else if (str[0].equals("back")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.getLast());
            }
        }


    }
}
