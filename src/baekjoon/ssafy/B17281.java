package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17281 {

    static int N;
    static int[][] data;
    static boolean[] base = new boolean[4];
    static int[] order = new int[10];
    static boolean[] visited = new boolean[10];
    static int result, score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        data = new int[N][10];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; ++j) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        // 타순 정하기 -> 모든 경우 계산해서 최대 득점 타순 찾기 -> 답 : 최대 득점
        // 4번 타자는 1번 선수
        order[4] = 1;
        visited[1] = true;
        permutation(1);

        System.out.println(result);
    }

    private static void permutation(int idx) {
        if (idx == 4) { // 4번 타자는 이미 정해져 있음
            permutation(idx+1);
            return ;
        }

        if (idx == 10) { // 타순 구성 완료
//            System.out.println(Arrays.toString(order));
            play();
            result = Math.max(result, score);
            return ;
        }

        for (int i = 2; i < 10; ++i) {
            if (visited[i]) continue;

            visited[i] = true;
            order[idx] = i;

            permutation(idx+1);

            visited[i] = false;
        }

    }

    private static void play() {
        score =  0;
        int num = 1;

        for (int i = 0; i < N; ++i) {
            int out = 0;
            base = new boolean[4];

//            loop:
            while (out < 3) {
                int state = data[i][order[num]];

                if (num == 9) num = 1;
                else num++;

                switch(state) {
                    case 0 : //  아웃
                        out++;
                        if(out == 3) {
//                            break loop; //이닝 종료
                        }
                        break;
                    case 1 :  // 1 루타
                        if(base[3]) {
                            score++; //3루 주자 홈인
                            base[3] = false;
                        }
                        for(int r = 3; r > 1; r--) { //r=3,2
                            base[r] = base[r-1]; //2루와 1루 주자 시프트
                        }
                        base[1] = true;//타자 1루 진루
                        break;
                    case 2 : // 2 루타
                        if(base[3]) {
                            score++; //3루 주자 홈인
                            base[3] = false;
                        }
                        if(base[2]) {
                            score++; //2루 주자 홈인
                            base[2] = false;
                        }
                        if(base[1]) { //1루 주자 3루 이동
                            base[3] = true;
                            base[1] = false;
                        }
                        base[2] = true;//타자 2루 진루
                        break;
                    case 3 : // 3 루타
                        if(base[3]) {
                            score++;//3루 주자 홈인
                            base[3] = false;
                        }
                        if(base[2]) {
                            score++;//2루 주자 홈인
                            base[2] = false;
                        }
                        if(base[1]) {
                            score++;//1루 주자 홈인
                            base[1] = false;
                        }
                        base[3] = true;//타자 3루 진루
                        break;
                    case 4 : //4 루타(홈런)
                        score++;//홈런의 점수 추가
                        for(int r = 1; r <=3; r++) {
                            if(base[r]) {//주자가 있다면
                                score++;//주자 점수 추가
                                base[r] = false;
                            }
                        }
                        break;
                }
            }
        }

    }


}