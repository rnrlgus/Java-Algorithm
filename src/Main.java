import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});

        for (int i = 1; i <= N; ++i) {
            int next = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {
                if (stack.peek()[1] < next) stack.pop();
                else break;
            }

            if (stack.isEmpty()) {
                sb.append(0 + " ");
            } else {
                sb.append(stack.peek()[0] + " ");
            }

            stack.push(new int[] {i, next});
        }

        System.out.println(sb);

    }





}

