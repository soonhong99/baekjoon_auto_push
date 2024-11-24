
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numExec = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < numExec; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                stack.pop();
            }
            else {
                stack.push(Integer.valueOf(input));
            }
        }

        int totalNum = 0;
        int totalSize = stack.size();
        for (int i = 0; i < totalSize; i++) {
            totalNum += stack.pop();
        }

        System.out.println(totalNum);
    }
}
