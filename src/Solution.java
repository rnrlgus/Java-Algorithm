import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());


        for (int t = 1; t <= TC; ++t) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            map = new int[N + 1][N + 1];


            for (int i = 0; i < M; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
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
            sb.append("#" + t + " " + answer).append("\n");
        }
        System.out.println(sb);
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
