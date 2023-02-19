import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    /*
        N*N 배열에 사탕 들어있음
        사탕의 색이 다른 인접한 두 칸을 고름
        고른 두 칸 사탕 교환
        같은 색으로 이루어진 가장 긴 부분(행/열) 사탕 모두 먹음
        먹을 수 있는 사탕의 최대 개수는?
     */

    static int n;
    static int max = Integer.MIN_VALUE;
    static char[][] map;

    static void check() {
        int cnt;
        for (int i = 0; i < n; ++i) {
            cnt = 1;
            for (int j = 0; j < n - 1; ++j) { // 행 체크
                if (map[i][j] == map[i][j + 1]) {
                    cnt += 1;
                } else {
                    if(cnt > max)max = cnt;
                    cnt = 1;
                }
                if(cnt > max)max = cnt;


            }

            cnt = 1;
            for (int j = 0; j < n-1; ++j) { // 열 체크
                if (map[j][i] == map[j+1][i]) {
                    cnt += 1;
                } else {
                    if(cnt > max)max = cnt;
                    cnt = 1;
                }
                if (cnt > max) max = cnt;
            }
        }
    }

    static void swap(int r, int c, int nr, int nc) {
        char tmp = map[r][c];
        map[r][c] = map[nr][nc];
        map[nr][nc] = tmp;
    }

    static void swapCheckRecover(int r, int c) {
        if (r == n - 1 && c == n - 1) {
            return ;
        }

        else if (r == n-1){ // 우 로만
            swap(r, c, r, c+1);
            check();
            swap(r, c, r, c+1);

        } else if (c == n - 1) { // 하로만
            swap(r, c, r+1, c);
            check();
            swap(r, c, r+1, c);

        } else { // 둘다
            swap(r, c, r, c+1);
            check();
            swap(r, c, r, c+1);

            swap(r, c, r+1, c);
            check();
            swap(r, c, r+1, c);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; ++i) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < n; ++j) {
                map[i][j] = tmp[j];
            }
        } // 입력 완료

        check(); // 최초 배열 체크

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                swapCheckRecover(i, j);
            }
        }

        System.out.println(max);
    }

}