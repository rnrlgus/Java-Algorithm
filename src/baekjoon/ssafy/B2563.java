package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2563 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[100][100];
        int cnt = 0;
        for (int i=0; i<n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j=y; j<y+10; ++j) {
                for (int k = x; k < x + 10; ++k) {
                    map[j][k] +=1;
                }
            }


        }
        for (int j = 0; j < 100; ++j) {
            for (int k = 0; k < 100; ++k) {
                if (map[j][k] != 0) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}