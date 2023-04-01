package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2239 {

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

    static int[][] map = new int[9][9];
    static List<Point> list = new ArrayList<>();
    static int size;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        for (int i = 0; i < 9; ++i) {
            String tmp = br.readLine();
            for (int j = 0; j < 9; ++j) {
                map[i][j] = tmp.charAt(j)-'0';
                if (map[i][j] == 0) list.add(new Point(i, j));
            }
        } // 입력 완료

        size = list.size();
        solution(0);
    }

    private static void solution(int idx) {
        if (idx == size) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        Point curr = list.get(idx);
        for (int i = 1; i <= 9; ++i) {
            if (checkBoard(curr.row, curr.col, i)) {
                map[curr.row][curr.col] = i;
                solution(idx + 1);
                map[curr.row][curr.col] = 0;
            }
        }
    }

    private static boolean checkBoard(int row, int col, int num) {
        for (int i = 0; i < 9; ++i) {
            if (map[row][i] == num) return false;
            if (map[i][col] == num) return false;
        }

        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; ++i) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; ++j) {
                if (map[i][j] == num) return false;
            }
        }
        return true;
    }


}