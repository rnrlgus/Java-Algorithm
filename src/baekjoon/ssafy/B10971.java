package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10971 {

    static int N;
    static int[][] adjMatrix;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        adjMatrix = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        dfs(0,0,0);
        System.out.println(min);
    }

    private static void dfs(int curr, int cost, int cnt) {
        if (cnt == N-1) {
            if (adjMatrix[curr][0] != 0){
                min = Math.min(min, cost + adjMatrix[curr][0]);
                return ;
            }
        }

        for (int i = 1; i < N; ++i) {
            if (!visited[i] && adjMatrix[curr][i] != 0) {
                visited[i] = true;
                dfs(i, cost + adjMatrix[curr][i], cnt+1);
                visited[i] = false;
            }
        }
    }

}