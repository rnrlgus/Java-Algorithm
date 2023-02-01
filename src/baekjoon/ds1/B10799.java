package baekjoon.ds1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10799 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        char[] cArr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int cnt = 0;

        for (int i = 0; i < cArr.length; ++i) {
            if (cArr[i] == '(') {
                stack.push(cArr[i]);
            } else if (cArr[i - 1] == ')') {
                stack.pop();
                cnt += 1;
            } else {
                stack.pop();
                cnt+= stack.size();
            }
        }


        System.out.println(cnt);
    }
}