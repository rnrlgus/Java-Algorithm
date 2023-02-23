package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1987 {

    static int R, C;
    static int[][] map;
    static boolean[] visited;

    // 우 하 좌 상
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[26]; // 알파벳 배열

        for (int i = 0; i < R; ++i) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < C; ++j) {
                map[i][j] = tmp[j]-'A';
            }
        } // 입력 완료

        dfs(0, 0, 0);
        System.out.println(result);
    }

    static void dfs(int y, int x, int cnt) {
        if(visited[map[y][x]]) {
            result = Math.max(result, cnt);
            return ;
        }

        visited[map[y][x]] = true;
        for (int i = 0; i < 4; ++i) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny>=0 && nx>=0 && ny < R && nx < C) dfs(ny, nx, cnt+1);
        }

        visited[map[y][x]] = false;
    }
}