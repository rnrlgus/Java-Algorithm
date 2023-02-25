package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15656 {

    static int N, M;
    static int[] nums;
    static boolean[] selected;
    static int[] result;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];
        nums = new int[N];
        selected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int dep, int start) {
        if (dep == M) {
            for (int x : result) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return ;
        }

        for (int i = 0; i < N; ++i) {
//            if (selected[i]) continue;

//            selected[i] = true;
            result[dep] = nums[i];
            dfs(dep+1, i+1);
//            selected[i] = false;
        }

    }

}