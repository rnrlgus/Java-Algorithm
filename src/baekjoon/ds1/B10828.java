package baekjoon.ds1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class B10828 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; ++i) {
            String str = bf.readLine();
            String[] arr = str.split(" ");

            if (arr[0].equals("push") ) {
                stack.push(Integer.parseInt(arr[1]));
            } else if (arr[0].equals("top") ) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            } else if (arr[0].equals("size")) {
                System.out.println(stack.size());
            } else if (arr[0].equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if (arr[0].equals("empty") ) {
                if (stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
        }


    }
}