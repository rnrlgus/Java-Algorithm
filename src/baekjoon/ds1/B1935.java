package baekjoon.ds1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1935 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Double> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        char[] arr = str.toCharArray();


        double first=0;
        double last=0;

        double[] nums = new double[n];

        int idx = 0;
        for (int i = 0; i < n; ++i) {
            nums[i] = Double.parseDouble(br.readLine());
        }


        char tmp = '?';

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '+') {
                last = stack.pop();
                first = stack.pop();
                stack.push(first + last);
            }
            else if (arr[i] == '-') {
                last = stack.pop();
                first = stack.pop();
                stack.push(first - last);
            }
            else if (arr[i] == '*') {
                last = stack.pop();
                first = stack.pop();
                stack.push(first * last);
            }
            else if (arr[i] == '/') {
                last = stack.pop();
                first = stack.pop();
                stack.push(first / last);
            } else {
                stack.push(nums[arr[i]-'A']);

            }
        }
        System.out.println(String.format("%.2f", stack.peek()));




    }
}
