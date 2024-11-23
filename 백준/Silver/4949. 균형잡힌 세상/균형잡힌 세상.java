
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
        while (true) {
            String[] input = br.readLine().split("");
            if (input[0].equals(".")) {
                break;
            }
            boolean isSymmetry = checkSymmetry(input);
            if (isSymmetry) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }

    private static boolean checkSymmetry(String[] input) {
        int maxLength = input.length;
        Deque<String> symmetryDeque = new ArrayDeque<>();
        boolean isSymmetry = true;

        for (int i = 0; i < maxLength; i++) {
            if (input[i].equals("[") || input[i].equals("(")) {
                symmetryDeque.addLast(input[i]);
            }
            if (input[i].equals("]")) {
                if (symmetryDeque.size() == 0) {
                    isSymmetry = false;
                    break;
                }
                String lastSymmetry = symmetryDeque.removeLast();
                if (!lastSymmetry.equals("[")) {
                    isSymmetry = false;
                    break;
                }
            }
            if (input[i].equals(")")) {
                if (symmetryDeque.size() == 0) {
                    isSymmetry = false;
                    break;
                }
                String lastSymmetry = symmetryDeque.removeLast();
                if (!lastSymmetry.equals("(")) {
                    isSymmetry = false;
                    break;
                }
            }
        }
        if (symmetryDeque.size() > 0) {
            isSymmetry = false;
        }
        return isSymmetry;
    }
}
