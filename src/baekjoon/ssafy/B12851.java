package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B12851 {

    /**
     * 수빈 : N, 동생 : K (각각 0 ~ 100,000)
     * 수빈이는 걷거나 순간이동 가능(부럽다..)
     * X 일 때 걷기 -> X-1 / X+1
     * X 일 때 순간이동 -> 1초 후에 2*X 로 이동
     *
     * 인풋 : 수빈 동생의 위치
     * 아웃풋 : 최대한 빨리 동생 찾기
     */

    static int N, K;
    static int[] visited;
    static int min = Integer.MAX_VALUE, cnt;


    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        if (N == K) {
            System.out.println(0 + "\n1");
            return ;
        }

        bfs(N);
        System.out.println(visited[K]-1);
        System.out.println(cnt);

    }

    static void bfs(int start) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = 1;

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            // 최소 시간보다 길 경우 찾을 필요가 없음
            if (min < visited[curr]) return ;

            for (int i = 0; i < 3; ++i) {
                int next;
                if (i == 0) next = curr-1;
                else if (i == 1) next = curr+1;
                else next = curr*2;

                if (next < 0 || next > 100000) continue;

                if (next == K) {
                    min = visited[curr];
                    cnt++;
                }

                if (visited[next] == 0 || visited[next] == visited[curr] + 1) {
                    queue.offer(next);
                    visited[next] = visited[curr]+1;
                }
            }
        }

    }



}
