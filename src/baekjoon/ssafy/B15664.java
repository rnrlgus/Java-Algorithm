package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class B15664 {

    static int N, M;
    static int[] nums;
    static boolean[] selected;
    static int[] result;
    static StringBuilder sb;
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];
        nums = new int[N];
        selected = new boolean[N];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0, 0);
        for (String s :set) {
            System.out.print(s);
        }
    }

    static void dfs(int dep, int start) {
        if (dep == M) {
            sb = new StringBuilder();
            for (int x : result) {
                sb.append(x + " ");
            }
            sb.append("\n");
            set.add(sb.toString());
            return ;
        }

        for (int i = start; i < N; ++i) {
            if (selected[i]) continue;

            selected[i] = true;
            result[dep] = nums[i];
            dfs(dep+1, i+1);
            selected[i] = false;
        }

    }

}