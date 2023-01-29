import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack.firstElement());
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.offer(1));
        queue.add(2);

        System.out.println(queue.poll());

        System.out.println(queue.peek());

    }

}
