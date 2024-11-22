
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception{
        // TODO: 프로그램 구현
        // 1234 -> 234 -> 342 -> 42 -> 24 -> 4
        // 12345 -> 2345 -> 3452 -> 452 -> 524 -> 24 -> 42 -> 2
        // 123456 -> 23456 -> 34562 -> 4562 -> 5624 -> 624 -> 246 -> 46 -> 64 -> 4
        // 246, 642 stack을 두개 만들까?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            stack.addLast(String.valueOf(i + 1));
        }

        int i = 1;
        while (stack.size() != 1) {
            if (i % 2 == 1) {
                String j = stack.removeFirst();
                // System.out.println("remove first = " + j);
            }
            else {
                String j = stack.removeFirst();
                // System.out.println("remove and add last = " + j);
                stack.addLast(j);
            }
            i++;
        }
        System.out.println(stack.getLast());
    }
}
