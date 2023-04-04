package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2458 {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N + 1][N + 1];


            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine());
                int low = Integer.parseInt(st.nextToken());
                int high = Integer.parseInt(st.nextToken());
                map[low][high] = 1;
            } // 입력 완료

            floydWarshall();

            int answer = 0;
            for (int i = 1; i <= N; ++i) {
                boolean flag = true;
                for (int j = 1; j <= N; ++j) {
                    if (i == j) continue;

                    if (map[i][j] != 1 && map[j][i] != 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        System.out.println(answer);
        }


    private static void floydWarshall() {
        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
                }
            }
        }
    }
}
