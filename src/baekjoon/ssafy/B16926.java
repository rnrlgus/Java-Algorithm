package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16926 {

    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료



        //         우 하 좌 상
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        int cycle = Math.min(n, m)/2;

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < cycle; ++j) {
                int dir = 0;

                int cy = j;
                int cx = j;
                int tmp = map[cy][cx];

                while (dir<4) {
                    int ny = cy + dy[dir];
                    int nx = cx + dx[dir];

                    if (ny >= j && ny < n - j && nx >= j && nx < m - j) {
                        map[cy][cx] = map[ny][nx];
                        cy = ny;
                        cx = nx;
                    } else dir++;
                }
                map[j+1][j] = tmp;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}