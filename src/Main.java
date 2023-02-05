import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]); // 행
        int m = Integer.parseInt(nm[1]); // 열

        int[][] map = new int[n][m];

        for (int i = 0; i < n; ++i) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < m; ++j) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int[][][] shape = {
                // 막대기
                {{0,0}, {0,1}, {0,2}, {0,3}},
                {{0,0}, {1,0}, {2,0}, {3,0}},
                // 주먹
                {{0,0}, {1,0}, {0,1}, {1,1}},
                // L
                {{0,0}, {0,1}, {0,2}, {1,2}},
                {{0,0}, {1,0}, {2,0}, {0,1}},
                {{0,0}, {1,0}, {1,1}, {1,2}},
                {{2,0}, {0,1}, {1,1}, {2,1}},
                {{1,0}, {1,1}, {1,2}, {0,2}},
                {{0,0}, {0,1}, {1,1}, {2,1}},
                {{0,0}, {1,0}, {0,1}, {0,2}},
                {{0,0}, {1,0}, {2,0}, {2,1}},
                // ㅗ
                {{0,0}, {1,0}, {2,0}, {1,1}},
                {{1,0}, {0,1}, {1,1}, {1,2}},
                {{0,1}, {1,0}, {1,1}, {2,1}},
                {{0,0}, {0,1}, {0,2}, {1,1}},
                // N
                {{0,0}, {0,1}, {1,1}, {1,2}},
                {{0,1}, {1,1}, {1,0}, {2,0}},
                {{1,0}, {1,1}, {0,1}, {0,2}},
                {{0,0}, {1,0}, {1,1}, {2,1}}
        };
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {

                for (int k = 0; k < shape.length; ++k) {

                    int tmp = 0;
                    for (int l = 0; l < 4; ++l) {
                        int nx = j + shape[k][l][0];
                        int ny = i + shape[k][l][1];

                        if (nx >= m || ny >= n) {
                            break;
                        }

                        tmp += map[ny][nx];
                    }

                    if (max < tmp) max = tmp;
//                    System.out.println(max);
                }
            }
        }
        System.out.println(max);
    }
}