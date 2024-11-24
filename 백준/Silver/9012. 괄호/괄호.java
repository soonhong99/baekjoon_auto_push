
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numExec = Integer.parseInt(br.readLine());
        for (int i = 0; i < numExec; i++) {
            boolean firstBreak = false;
            String[] input = br.readLine().split("");
            int count = 0;
            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("(")) {
                    count++;
                }
                else if (input[j].equals(")")) {
                    count--;
                }
                if (count < 0) {
                    System.out.println("NO");
                    firstBreak = true;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("YES");
            }
            else if (count != 0 && !firstBreak) {
                System.out.println("NO");
            }
        }
    }
}
