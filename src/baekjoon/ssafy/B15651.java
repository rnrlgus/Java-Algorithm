package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15651 {

    static int N, M;
    static int[] result;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int dep) {
        if (dep == M) {
            for (int x : result) {
                sb.append(x + " ");
            }
            sb.append("\n");

            return ;
        }

        for (int i = 1; i <= N; ++i) {
            result[dep] = i;
            dfs(dep+1);
        }

    }

}