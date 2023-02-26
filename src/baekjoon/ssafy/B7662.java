package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B7662 {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; ++t) {
            int k = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> minQue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < k; ++i) {
                st = new StringTokenizer(br.readLine());
                char operator = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (operator == 'I'){ // insert
                    map.put(n, map.getOrDefault(n, 0)+1);
                    maxQue.offer(n);
                    minQue.offer(n);

                } else { // delete
                    if (map.isEmpty()) continue; // 비어있을 때 스킵

                    if (n == 1) { // 최대 값 삭제
                        removeQueMap(maxQue, map);
                    }

                    if (n == -1){ // 최소 값 삭제
                        removeQueMap(minQue, map);
                    }

                }

            }

            if (map.isEmpty()) System.out.println("EMPTY");
            else {
                int max = removeQueMap(maxQue, map);
                int min;
                if (map.isEmpty()) {
                    min =max;
                } else {
                    min = removeQueMap(minQue, map);
                }

                System.out.println(max + " " + min);
            }
        }


    }

    static int removeQueMap(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
        int num;
        while(true){
            num = que.poll();
            int cnt = map.getOrDefault(num, 0);

            if (cnt == 0) continue; // dummy 값 스킵

            if (cnt == 1) map.remove(num); // 1개일 때 map에서 삭제
            else map.put(num, cnt-1); // 많을 때 하나 줄여주기

            break; // dummy 값이 아닌경우 지우고 루프 탈출
        }

        return num;
    }



}

