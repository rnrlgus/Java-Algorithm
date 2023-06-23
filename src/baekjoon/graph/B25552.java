package baekjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B25552 {

    static class Grass {
        int row, col;
        int d;

        public Grass(int row, int col, int d) {
            this.row = row;
            this.col = col;
            this.d = d;
        }
    }

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N, M, D;
    static int[][] initialGrass;
    static int[][] expectedGrass;
    static Queue<Grass> queue = new ArrayDeque<>();
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        initialGrass = new int[N][M];
        expectedGrass = new int[N][M];
        visited = new boolean[10][N][M];

        for (int i = 0; i < N; ++i) {
            String str = br.readLine();
            for (int j = 0; j < M; ++j) {
                if (str.charAt(j) == 'O') {
                    initialGrass[i][j] = 1;
                    queue.add(new Grass(i, j, 0));
                    visited[0][i][j] = true;
                } else {
                    initialGrass[i][j] = 0;
                }
            }
        }

        D = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            String str = br.readLine();
            for (int j = 0; j < M; ++j) {
                if (str.charAt(j) == 'O') expectedGrass[i][j] = 1;
                else expectedGrass[i][j] = 0;
            }
        } // 입력 완료

        bfs();

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (initialGrass[i][j] != expectedGrass[i][j]) {
                    System.out.println("NO");
                    return ;
                }
            }
        }

        System.out.println("YES");

    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            Grass curr = queue.poll();
            dfs(curr.row, curr.col, curr.d);
        }
    }

    private static void dfs(int row, int col, int d) {

        if (d == D) {
            return ;
        }
        for (int i = 0; i < 4; ++i) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 || nc < 0 || nr >=N || nc >= M || visited[d+1][nr][nc]) continue;

            visited[d + 1][nr][nc] = true;
            if (initialGrass[nr][nc] == 0 && expectedGrass[nr][nc] == 1) {
                initialGrass[nr][nc] = 1;
                queue.offer(new Grass(nr, nc, 0));
            } else if (expectedGrass[nr][nc] == 0) dfs(nr, nc, d + 1);
        }
    }

}
