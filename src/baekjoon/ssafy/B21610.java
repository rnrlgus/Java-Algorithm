package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B21610 {

    /**
     * 비바라기 구현
     * map = N*N
     * map 각 칸 : 바구니 (물 저장량 제한 X)
     * 왼쪽 위 칸 : (1,1) / 오른쪽 아래 칸 : (N,N)
     * 1번 행, N번 행 연결됨 / N행 아래에 1행, 1행 위에 N행
     * 1번 열, N번 열 연결됨 / 1열 왼쪽에 N열, N열 오른쪽에 1번 열
     * 비바라기 시전 -> (N,1), (N,2), (N-1,1), (N-1,2)에 비구름 생김
     * 비구름에 이동 명령 M번 실행
     * i번째 이동 명령 : dir[i], (si) distance[i]
     * 1부터 순서대로 좌 좌상 상 우상 우 우하 하 좌하
     *
     * **명령 실행시**
     * 1. 모든 구름이 di 방향으로 si칸 이동
     * 2. 각 구름이 있는 칸 물 양 +1
     * 3. 구름 모두 사라짐
     * 4. 2에서 물이 증가한 칸들의 대각선 방향으로 거리가 1인 칸에 물이 있는
     * 바구니의 수만큼 물 양 증가
     * 5. 물의 양이 2 이상인 모든 칸에 구름이 생기고 물의 양 -2 (3에서 제거된 구름 제외)
     *
     * result : M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합
     *
     */

    /**
     * 회고
     *
     * 1.
     * 이 문제처럼 메서드를 여러개 만들어야 하는 문제의 경우
     * 이 문제를 푼 시점까지는 그냥 무지성으로 메서드를 모두 작성하고 디버깅을 했다.
     * 별로 틀릴 가능성이 없을 것 같다는 오만한 생각이 기반되었다.
     * 하지만 오늘 낭패를 봤다. 더럽게 오래걸렸다.
     * 메서드를 하나 작성하고 테스트를 꼭 꼭 꼭 하는 습관을 가져야겠다.
     * 각각의 메서드를 작성 -> 테스트 -> 통합
     *
     * 2.
     * 5번 메서드를 작성할 때 3번 과정에서 사라졌던 구름인지 체크할 때
     * 다른 방법이 떠오르지 않아 리스트에 넣고 순회하며 탐색했다.
     * 처음에 set에 넣고 row, col이 같은 원소가 존재하는지 체크하는 방식으로 하려했는데
     * set의 경우 객체 자체가 들어있기 때문에
     * 값을 비교하는 게 제한되어 이렇게 했다.
     * 다른 방법이 없을까
     *
     * 3.
     * 문제에 tc에 대한 시뮬레이션 예시가 있다면 꼭 정독하자
     * 글로만 읽으면 문제의 의도와 틀어질 수 있다는 것을 깨달았다.
     * 국어 못하면 그림이라도 잘 보자
     *
     */

    static class Cloud {
        int row;
        int col;

        public Cloud(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Cloud{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    static int N, M, sum;
    static int[][] map;
    // 좌 좌상 상 우상 우 우하 하 좌하
    static int[] dr = {999, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {999, -1, -1, 0, 1, 1, 1, 0, -1};

    // 좌상 우상 좌하 우하
    static int[] diagnalRow = {-1, -1, 1, 1};
    static int[] diagnalCol = {-1, 1, -1, 1};
    static ArrayList<Cloud> clouds = new ArrayList<>();
    static ArrayList<Cloud> prevClouds = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        int dir, distance;

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 맵 입력

        // 초기 구름 위치
        clouds.add(new Cloud(N, 1));
        clouds.add(new Cloud(N, 2));
        clouds.add(new Cloud(N-1, 1));
        clouds.add(new Cloud(N-1, 2));

        for (int o = 0; o < M; ++o) {

            st = new StringTokenizer(br.readLine());
            dir = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());

            oneToFour(dir, distance);

            five();
        }

        // result
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);

    }

    static void oneToFour(int dir, int distance) {
        for (int i = 0; i < clouds.size(); ++i) {
            int row = clouds.get(i).row;
            int col = clouds.get(i).col;

            int nr = row + dr[dir] * distance;
            int nc = col + dc[dir] * distance;

            // 격자 벗어날 때 적절하게 변환해주기
            while(!(nr >=1 && nr <= N)) {
                if (nr < 1) nr += N;
                if (nr > N) nr -= N;
            }

            while(!(nc >=1 && nc <= N)) {
                if (nc < 1) nc += N;
                if (nc > N) nc -= N;
            }

            // 옮긴 구름 위치 값 1 증가
            map[nr][nc]++;

            // 5번에서 제외할 구름들 갱신
            prevClouds.add(new Cloud(nr, nc));
        }

        // 4번 실행
        four();

        // 구름 제거
        clouds.clear();
    }

    static void four() {
        for (int i = 0; i < prevClouds.size(); ++i) {
            int row = prevClouds.get(i).row;
            int col = prevClouds.get(i).col;

            int cnt = 0;
            for (int j = 0; j < 4; ++j) {
                int nr = row + diagnalRow[j];
                int nc = col + diagnalCol[j];

                // 유효할 때만
                if (nr >=1 && nc >= 1 && nr <= N && nc <= N) {
                    if (map[nr][nc] > 0) cnt++;
                }
            }
            map[row][col] += cnt;

        }
    }

    // 보완 필요 (3번 단계에서 구름이 사라졌던 위치인지 체크할 때 너무 비효율적인 듯)
    static void five() {
        for (int i=1; i<=N; ++i) {
            for (int j = 1; j <= N; ++j) {
                boolean flag = true;
                for (int k=0; k<prevClouds.size(); ++k) {
                    if (prevClouds.get(k).row == i && prevClouds.get(k).col == j) {
                        flag = false;
                        prevClouds.remove(k);
                    }
                }
                // 조건에 충족할 때 5번 실행
                if (flag == true) {
                    if (map[i][j] >= 2) {
                        clouds.add(new Cloud(i, j));
                        map[i][j]-= 2;
                    }
                }
            }
        }
        // 이전 구름 리스트 초기화
        prevClouds.clear();
    }

}

