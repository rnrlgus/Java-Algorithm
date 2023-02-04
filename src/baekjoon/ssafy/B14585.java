package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14585 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] dp = new int[301][301];
        for (int i = 0; i < n; ++i) {
            String[] xy = br.readLine().split(" ");
            dp[Integer.parseInt(xy[0])][Integer.parseInt(xy[1])] = -1;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 301; ++i) {
            for (int j = 0; j < 301; ++j) {
                if (i ==0 && j == 0) continue;
                if (i == 0) {
                    if (dp[i][j] == -1) { // 사탕 바구니 있을 때
                        dp[i][j] = (m-i-j) + dp[i][j-1];
                    } else { // 사탕 바구니 없을 때
                        dp[i][j] = dp[i][j-1];
                    }

                } else if (j == 0) {
                    if (dp[i][j] == -1) {
                        dp[i][j] = (m - i - j) + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    if (dp[i][j] == -1) {
                        dp[i][j] = (m - i - j) + Math.max(dp[i - 1][j], dp[i][j - 1]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
                if (dp[i][j] > max) max = dp[i][j];

            }
        }
        System.out.println(max);

    }
}