
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push"))
                stack.push(Integer.valueOf(input[1]));
            if (input[0].equals("front")) {
                if (stack.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.getLast());
                }
            }
            if (input[0].equals("back")) {
                if (stack.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.getFirst());
                }
            }
            if (input[0].equals("size"))
                System.out.println(stack.size());
            if (input[0].equals("empty")) {
                if (stack.size() == 0) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            if (input[0].equals("pop")) {
                if (stack.size() == 0) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.removeLast());
                }
            }
        }
    }
}
