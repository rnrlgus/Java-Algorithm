package baekjoon.ds1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < n; ++i) {
            String result = "NO";
            String str = bf.readLine();
            char[] chr = str.toCharArray();

            for (char c : chr) {
                if (c == '(') stack.push(c);
                else if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                    break;
                }

            }

            if (stack.isEmpty()) result = "YES";

            stack.clear();

            System.out.println(result);
        }

        bf.close();
    }
}
