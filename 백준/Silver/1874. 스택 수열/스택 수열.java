
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfInput = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        List<String> pushAndPopList = new ArrayList<>();
        boolean isStack = true;

        int currentNum = 1;
        // int highNum = 1;
        stack.add(currentNum);
        pushAndPopList.add("+");

        /*
        없앴는데 기억을 해야돼 -> 마지막에 어떤걸 썼지?
        push: 1, 2, 3, 4, 5, 6, 7, 8
        pop:  4, 3, 6, 8, 7, 5, 2, 1
         */


        for (int i = 0; i < numOfInput; i++) {
            int inputNum = Integer.parseInt(br.readLine());
            while (true) {
                if (currentNum < inputNum) {
                    currentNum++;
                    // highNum++;
                    stack.add(currentNum);
                    pushAndPopList.add("+");
                }
                else {
                    int removeNum;
                    if (stack.size() != 0)
                        removeNum = stack.removeLast();
                    else {
                        isStack = false;
                        break;
                    }
                    pushAndPopList.add("-");
                    if (removeNum == inputNum)
                        break;
                }
            }
            if (!isStack)
                break;
        }
        if (isStack) {
            pushAndPopList.forEach(System.out::println);
        }
        else {
            System.out.println("NO");
        }
    }
}
