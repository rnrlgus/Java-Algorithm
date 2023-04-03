package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B9205 {

    static class Point {
        int no;
        int row, col;

        public Point(int no, int row, int col) {
            super();
            this.no = no;
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Point [no=" + no + ", row=" + row + ", col=" + col + "]";
        }

    }

    static int N;
    static List<Point> list;
    static int[][] adjMatrix;
    static boolean[] visited;
    static int INF = 999999;
    static boolean flag;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for(int t=0; t<TC; ++t) {
            flag = false;

            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            adjMatrix = new int[N+2][N+2];
            visited = new boolean[N+2];

            for(int i=0; i<N+2; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new Point(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            for(int i=0; i<N+2; ++i) {
                Point curr = list.get(i);
                for(int j=0; j<N+2; ++j) {
                    adjMatrix[i][j] = Math.abs(list.get(j).row - curr.row) + Math.abs(list.get(j).col - curr.col);
                }
            }

//			for(int i=0; i<N+2; ++i) {
//				System.out.println(Arrays.toString(adjMatrix[i]));
//			}

//			bfs();
//			floydWarshall();
            dfs(0);
            System.out.println(flag? "happy" : "sad");

        }

    }


    private static void bfs() {
        // TODO Auto-generated method stub
        Queue<Point> queue = new ArrayDeque<>();

        queue.offer(list.get(0));

        while(!queue.isEmpty()) {


            Point curr = queue.poll();
            visited[curr.no] = true;

            if(curr.row == list.get(list.size()-1).row && curr.col == list.get(list.size()-1).col) {
                System.out.println("happy");
                return ;
            }

            for(int i=0; i<N+2; ++i) {
                if(adjMatrix[curr.no][i] >= 0 && adjMatrix[curr.no][i] <= 1000 && !visited[i]) {
                    queue.offer(new Point(i, list.get(i).row, list.get(i).col));
                }
            }


        }
        System.out.println("sad");
    }


    static void floydWarshall() {
        for(int i=0; i<N+2; ++i) {
            for(int j=0; j<N+2; ++j) {
                if(i!=j && adjMatrix[i][j] > 1000) adjMatrix[i][j] = INF;
            }
        }


        for(int k=0; k<N+2; ++k) {
            for(int i=0; i<N+2; ++i) {
                if(k == i) continue;
                for(int j=0; j<N+2; ++j) {
                    if(i == j || k == j) continue;
                    if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                }
            }
        }


        if(adjMatrix[0][N+1] < INF) System.out.println("happy");
        else System.out.println("sad");
    }

    static void dfs(int idx) {

        if(flag) return ;

        if(idx == N+1) {
            flag = true;
            return ;
        }

        for(int i=0; i<N+2; ++i) {
            if(adjMatrix[idx][i] <=1000 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }




}
