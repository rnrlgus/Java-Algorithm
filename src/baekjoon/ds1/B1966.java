package baekjoon.ds1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class B1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> idxQueue = new LinkedList<>();

        int tc = Integer.parseInt(br.readLine());


        for (int i = 0; i < tc; ++i) {

            queue.clear();
            idxQueue.clear();

            // n, idx
            String str = br.readLine();
            String[] arr = str.split(" ");

            int n = Integer.parseInt(arr[0]);
            int idx = Integer.parseInt(arr[1]);

            String str2 = br.readLine();
            String[] arr2 = str2.split(" ");

            for (int j = 0; j < n; ++j) {
                queue.offer(Integer.parseInt(arr2[j]));
                idxQueue.offer(j);
            }

            int cnt = 1;

            while (!queue.isEmpty()) {
                int max = Collections.max(queue);
                int cur = queue.poll();
                int curIdx = idxQueue.poll();

                if (cur == max) {
                    if (curIdx == idx) {
                        System.out.println(cnt);
                        break;
                    }
                    cnt++;
                }
                else {
                    queue.offer(cur);
                    idxQueue.offer(curIdx);
                }
            }

        }
    }
}