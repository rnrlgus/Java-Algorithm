package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B21544 {


    static boolean check(int[] arr) {
        boolean result = true;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < arr[i-1]) result = false;
        }

        return result;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] arr = new int[tmp.length];

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        int start=0;
        int end=0;

        int min = 0;
        int cnt = 0;
        while(true) {
            if (cnt > 100) {
                System.out.println(-1);
                break;
            }

            if (check(arr)) {
                System.out.println(cnt);
                System.out.println(sb);
                break;
            }

            // 구간 찾기
            for (int i = min; i < n; ++i) {
                min += 1;
                if (arr[i] == min) {
                    continue;
                } else {
                    start = i;
                }

                for (int j = start+1; j < n; ++j) {
                    if (arr[j] == min) {
                        end = j;
                        break;
                    }
                }
                break;
            }
            sb.append(start+1).append(" ").append(end+1).append("\n");

            // 뒤집기
            int asd = (end - start+1) / 2;
            for (int i = 0; i < asd; ++i) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
            cnt++;
        }

    }
}