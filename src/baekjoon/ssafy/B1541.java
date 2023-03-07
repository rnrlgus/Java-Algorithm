package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1541 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer minusTokens = new StringTokenizer(str, "-");

        int answer = 0;
        boolean flag = true;

        while(minusTokens.hasMoreTokens()) {
            int plusVal = 0;
            String subStr = minusTokens.nextToken();
            StringTokenizer plusTokens = new StringTokenizer(subStr, "+");

            while(plusTokens.hasMoreTokens()) {
                plusVal += Integer.parseInt(plusTokens.nextToken());
            }

            if (flag) {
                answer = plusVal;
                flag = false;
            } else {
                answer -= plusVal;
            }

        }

        System.out.println(answer);
    }


}