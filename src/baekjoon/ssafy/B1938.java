package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B1938 {

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    static class State {
        int row, col, dir, cnt;

        public State(int row, int col, int dir, int cnt) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "State{" +
                    "row=" + row +
                    ", col=" + col +
                    ", dir=" + dir +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    static int N;
    static char[][]  map;

    static Point[] BP = new Point[3];
    static Point[] EP = new Point[3];

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        int bi=0, ei=0;
        for (int i = 0; i < N; ++i) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; ++j) {
                if (map[i][j] == 'B') BP[bi++] = new Point(i, j);
                if (map[i][j] == 'E') EP[ei++] = new Point(i, j);
            }
        } // 입력 완료

        System.out.println(bfs());
    }

    private static int bfs() {

        // 가로/세로    row     col
        boolean[][][] visited = new boolean[2][N][N];
        Queue<State> queue = new ArrayDeque<>();

        int dir=0;
        // 가로일 경우
        if (BP[0].col + 1 == BP[1].col) dir = 0;
        // 세로일 경우
        else dir = 1;

        queue.offer(new State(BP[1].row, BP[1].col, dir, 0));
        visited[dir][BP[1].row][BP[1].col] = true;

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            if (curr.row == EP[1].row && curr.col == EP[1].col) {
                // 가로 가로 도착
                if (curr.dir == 0 && map[curr.row][curr.col] == 'E' && map[curr.row][curr.col + 1] == 'E'){
                    return curr.cnt;
                }

                // 세로 세로 세로
                if (curr.dir == 1 && map[curr.row][curr.col] == 'E' && map[curr.row+1][curr.col] == 'E'){
                    return curr.cnt;
                }
            }

            // 사방 탐색
            for (int i = 0; i < 4; ++i) {
                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];

                // 가로일 경우
                if (curr.dir == 0) {
                    if (!checkHoriz(nr, nc, i)) continue;
                }
                else {
                    if (!checkVerti(nr, nc, i)) continue;
                }

                if (visited[curr.dir][nr][nc]) continue;

                visited[curr.dir][nr][nc] = true;
                queue.offer(new State(nr, nc, curr.dir, curr.cnt + 1));
            }

            if (canRotation(curr.row, curr.col)) {

                if (curr.dir == 0 && !visited[1][curr.row][curr.col]) {
                    visited[1][curr.row][curr.col] = true;
                    queue.offer(new State(curr.row, curr.col, 1, curr.cnt + 1));
                }

                if (curr.dir == 1 && !visited[0][curr.row][curr.col]) {
                    visited[0][curr.row][curr.col] = true;
                    queue.offer(new State(curr.row, curr.col, 0, curr.cnt + 1));
                }
            }
        }

        return 0;
    }

    private static boolean canRotation(int row, int col) {
        for (int i = row - 1; i <= row + 1; ++i) {
            for (int j = col - 1; j <= col + 1; ++j) {
                if (i < 0 || j < 0 || i >=N || j >=N || map[i][j]== '1') return false;
            }
        }

        return true;
    }

    private static boolean checkVerti(int row, int col, int d) {
        if (d < 2) {
            if (row < 1 || row >= N-1) return false;
            if (map[row][col] == '1' || map[row-1][col] == '1' || map[row+1][col] == '1') return false;
        }
        else {
            if (col < 0 || col >= N) return false;
            if (map[row][col] == '1' || map[row-1][col] == '1' || map[row+1][col] == '1') return false;
        }

        return true;
    }

    public static boolean checkHoriz(int row, int col, int d) {
        if (d < 2) {
            if (row < 0 || row >= N) return false;
            if (map[row][col] == '1' || map[row][col - 1] == '1' || map[row][col + 1] == '1') return false;
        }
        else {
            if (col < 1 || col >= N-1) return false;
            if (map[row][col] == '1' || map[row][col - 1] == '1' || map[row][col + 1] == '1') return false;
        }

        return true;
    }


}
