package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686 {

    static int N, M;
    static int[][] map;
    static ArrayList<Point> homes = new ArrayList<>();
    static ArrayList<Point> bbqs = new ArrayList<>();

    static boolean[] survived;
    static int result, cityVal;

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }


    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 남길 치킨집 수의 하한선 (m ~ 13)

        map = new int[N][N];

        for(int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) homes.add(new Point(i,j));
                if(map[i][j] == 2) bbqs.add(new Point(i,j));
            }
        } // 입력 완료

        /*
         * 0 : 빈칸
         * 1 : 집
         * 2 : 치킨집
         * 도시 치킨거리 : 각 집의 치킨거리의 합
         */

        result = Integer.MAX_VALUE;



        survived = new boolean[bbqs.size()];

        combination(0, M);
//      for(int i=M; i<=bbqs.size(); ++i) { // 조합 개수
//         survived = new boolean[bbqs.size()];
//
//         combination(0, M);
//
//
//
//      }
        System.out.println(result);

    }

    private static void combination(int start, int r) {
        // TODO Auto-generated method stub
        if(r == 0) { // 부분집합 치킨거리 계산
//         System.out.println(Arrays.toString(survived));
            getScore(); // 치킨 조합 구해진 상태에서 치킨 거리 구하기
            return ;
        }

        for(int i=start; i<survived.length; ++i) {
            survived[i] = true;
            combination(i+1, r-1);
            survived[i] = false;
        }

    }

    private static void getScore() {
        cityVal = 0;

        for(int i=0; i<homes.size(); ++i) { // 각 집 순회
            int homeX = homes.get(i).x;
            int homeY = homes.get(i).y;

            int asd = Integer.MAX_VALUE;

            for(int j=0; j<survived.length; ++j) { // 치킨집 순회
                int tmp = 0;
                if(survived[j] == true) { // 각 치킨집
                    int bbqX = bbqs.get(j).x;
                    int bbqY = bbqs.get(j).y;

//               System.out.println(homes.get(i) +  " " + bbqs.get(i));

                    tmp += Math.abs(bbqX - homeX) + Math.abs(bbqY - homeY);
//               System.out.println(tmp);
                    if(tmp < asd) asd = tmp;
                }
            }
            cityVal+=asd;

        }

        if(result > cityVal) result = cityVal;

//      System.out.println(cityVal);

    }

}