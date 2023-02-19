package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9996 {

    static void solution(String input, String[] pattern) {
        String result = "DA";

        char[] inputArr = input.toCharArray();
        char[] front = pattern[0].toCharArray();
        char[] end = pattern[1].toCharArray();

        // 길이 체크
        if( input.length() < front.length + end.length){
            System.out.println("NE");
            return ;
        }

        // * 앞 뒤 체크
        for (int i = 0; i < front.length ; ++i) {
            if (inputArr[i] != front[i]) {
                result = "NE";
                break;
            }
        }
        for (int i = 0; i< end.length; ++i) {
            if (inputArr[i + (inputArr.length - end.length)] != end[i]) {
                result = "NE";
                break;
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");

        for (int i = 0; i < n; ++i) {
            String input = br.readLine();
            solution(input, pattern);
        }

    }

}