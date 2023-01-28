import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        ArrayList<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; ++i) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < k-1; ++i) {
                int front = queue.poll();
                queue.add(front);
            }
            int r = queue.poll();
            result.add(r);
        }

        String resultString = "<";
        for (int x : result) {
            resultString += (x + ", ");
        }
        resultString = resultString.substring(0, resultString.length() - 2);
        resultString += ">";

        System.out.println(resultString);
    }
}