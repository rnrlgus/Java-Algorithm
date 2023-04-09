package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600 {

    static class Point {
        int row, col;
        int k; // 말 이동 횟수
        int cnt; // 총 이동 횟수

        public Point(int row, int col, int k, int cnt) {
            this.row = row;
            this.col = col;
            this.k = k;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    ", k=" + k +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    static int H, W, K;
    static int[][] map;
    static boolean[][][] visited;

    // 사방 + 나이트
    static int[] dr= {-1,1,0,0,  1,2,2,1,  -1,-2,-2,-1};
    static int[] dc= {0,0,-1,1, -2,-1,1,2,  2,1,-1,-2};

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        for (int i = 0; i < H; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        bfs();
        System.out.println(answer == Integer.MAX_VALUE? -1 : answer);

    }

    private static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            int r = curr.row;
            int c = curr.col;
            int k = curr.k;
            int cnt = curr.cnt;

            if (r == H-1 && c == W-1) {
                answer = Math.min(answer, cnt);
                break;
            }

            for (int d = 0; d < (k == K ? 4 : 12); ++d) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                int nk = d<4? k : k+1;

                if (nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
                if (visited[nr][nc][nk] || map[nr][nc] == 1) continue;
                visited[nr][nc][nk] = true;
                queue.offer(new Point(nr, nc, nk, cnt+1));
            }
        }
    }

}
