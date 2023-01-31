package baekjoon.ds1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();


        int n = Integer.parseInt(br.readLine());

        boolean escape = false;
        int tmp = 1;
        for (int i = 0; i < n; ++i) {
            if (escape == true) break;

            int seq = Integer.parseInt(br.readLine());

            for (; tmp <= seq; ++tmp) {
                stack.push(tmp);
                sb.append("+ \n");
            }

            if (stack.peek() == seq) {
                stack.pop();
                sb.append("- \n");
            } else escape = true;


        }

        if (escape == true) System.out.println("NO");
        else System.out.println(sb);
    }
}