package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B21608 {

    static class Student{
        int num;
        int[] favorites;

        public Student(int num, int[] favorites) {
            this.num = num;
            this.favorites = favorites;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "num=" + num +
                    ", favorites=" + Arrays.toString(favorites) +
                    '}';
        }
    }

    static class Seat implements Comparable<Seat>{
        int x;
        int y;
        int like; // 인접한 칸에 있는 좋아하는 친구들 수
        int empty; // 주위에 빈 칸 수

        public Seat(int x, int y) {
            this.x = x;
            this.y = y;
        }


        // 문제 조건에 따라 내림차순 정렬
        @Override
        public int compareTo(Seat o) {
            if (this.like != o.like) {
                return o.like - this.like;
            }
            if (this.empty != o.empty) {
                return o.empty - this.empty;
            }

            // 좌표는 내림차순으로
            if (this.x != o.x) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }

        @Override
        public String toString() {
            return "Seat{" +
                    "x=" + x +
                    ", y=" + y +
                    ", like=" + like +
                    ", empty=" + empty +
                    '}';
        }
    }

    static int N;
    static List<Student> students = new ArrayList<>();
    static Student[][] map;
    // 상 하 좌 우
    static int[] dy = new int[] {-1, 1, 0, 0};
    static int[] dx = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new Student[N][N];

        for (int i = 0; i < N*N; ++i) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            students.add(new Student(num, new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())}));
        } // 입력 완료


        // 배치
        for (Student std: students) {
            findSeat(std.num, std.favorites);
        }

        // 테스트 출력
//        for (Student[] sds:map) {
//            System.out.println(Arrays.toString(sds));
//        }

        // 결과 계산 및 출력
        System.out.println(getSatisfaction());
    }

    static void findSeat(int num, int[] favotites) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i][j] == null) {
                    seats.add(check(i, j, favotites));
                }
            }
        }
        Collections.sort(seats);
//        System.out.println(seats);

        map[seats.get(0).y][seats.get(0).x] = new Student(num, favotites);
    }

    static Seat check(int y, int x, int[] favorites) {
        Seat seat = new Seat(x, y);
        for (int i = 0; i < 4; ++i) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny>=0 && nx>=0 && ny <N && nx < N) {
                if (map[ny][nx] == null) seat.empty++;
                else {
                    for (int j = 0; j < 4; ++j) {
                        if (favorites[j] == map[ny][nx].num) seat.like++;
                    }
                }
            }
        }

        return seat;
    }

    static int getSatisfaction() {
        int result = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                result += Math.pow(10, check(i, j, map[i][j].favorites).like-1);
            }
        }
        return result;
    }
}