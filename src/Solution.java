import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N, M, C;
    static int[][] map;
    static boolean[][] selected;
    static int max, aValue = Integer.MIN_VALUE, bValue = Integer.MIN_VALUE, value;

    static int[] aSelected;
    static int[] bSelected;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; ++t) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            selected = new boolean[N][N];
            aSelected = new int[M];
            bSelected = new int[M];

            max = Integer.MIN_VALUE;
            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            } // 입력 완료

            combination(0, 0, 0);
            System.out.println("#" + t + " " + max);
        }
    }

    private static void combination(int dep, int row, int col) {
        boolean flag = true;

        if (dep == 2) {
            getArr();

            aValue = bValue = 0;
            powerSet(0, 0, 0, 0, aSelected);
            powerSet2(0, 0, 0, 0, bSelected);
            value = aValue + bValue;
            max = Math.max(max, value);

            return ;
        }

        for (int r = row; r < N; ++r) {
            for (int c = col; c <= N - M; ++c) {
                flag = true;
                // 사용 가능한지 체크
                for (int i = 0; i < M; ++i) {
                    if (selected[r][c+i]) flag = false;
                    break;
                }

                // 사용 가능할 때만
                if (flag) {
                    // 사용
                    for (int i = 0; i < M; ++i) {
                        selected[r][c+i] = true;
                    }

                    if (c == N-M) combination(dep+1, r+1,0);
                    else combination(dep+1, r,c);

                    // 반납
                    for (int i = 0; i < M; ++i) {
                        selected[r][c+i] = false;
                    }

                }
            }
        }
    }

    private static void powerSet(int start, int dep, int count, int sum, int[] arr) {
        if (count > C) return ;

        if (dep == M) {
            aValue = Math.max(aValue, sum);
            return ;
        }

        for (int i = start; i < M; ++i) {
            powerSet(i+1, dep+1, count + arr[i], sum + (int)Math.pow(arr[i], 2), arr);
            powerSet(i+1, dep+1, count, sum, arr);
        }
    }

    private static void powerSet2(int start, int dep, int count, int sum, int[] arr) {
        if (count > C) return ;

        if (dep == M) {
            bValue = Math.max(bValue, sum);
            return ;
        }

        for (int i = start; i < M; ++i) {
            powerSet2(i+1, dep+1, count + arr[i], sum + (int)Math.pow(arr[i], 2), arr);
            powerSet2(i+1, dep+1, count, sum, arr);
        }
    }

    private static void getArr() {
        int count = 1;
        int idx = 0;
        for (int r = 0; r < N; ++r) {
            if (count == 2*M +1) break;
            for (int c = 0; c < N; ++c) {
                if (count == 2*M +1) break;
                if (selected[r][c]) {
                    if (count == M+1)  idx = 0;
                    if (count > M){
                        bSelected[idx] = map[r][c];
                    }
                    else {
                        aSelected[idx] = map[r][c];
                    }
                    count++;
                    idx++;
                }

            }
        } // a, b 후보 배열 구성 완료
    }


}