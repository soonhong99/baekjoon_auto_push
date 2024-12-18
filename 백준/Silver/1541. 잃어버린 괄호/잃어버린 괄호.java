
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
        String input = br.readLine();
        ArrayList<Integer> numList = new ArrayList<>();
        String currentNumString = "";
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                numList.add(Integer.parseInt(currentNumString));
                currentNumString = String.valueOf(c);
            }
            else {
                currentNumString += c;
            }
        }
        numList.add(Integer.parseInt(currentNumString));
        /*
        괄호를 어떻게 표현할 것인가?
        50-40-40+50-60
        -60+50-100+40+50
        음수 값이 뒤에 있는 양수 값이랑 엮이고, 나중에 음수화하는 것이 최소값으로 나온다.
         */
        int totalMinimum = 0;
        for (int i = 0; i < numList.size() - 1; i++) {
            if (numList.get(i) < 0) {
                int nextNum = numList.get(i + 1);

                if (nextNum > 0) {
                    numList.remove(i + 1);
                    numList.add(i + 1, nextNum * -1);
                }

            }
        }

        for (int i : numList) {
            totalMinimum += i;
        }

        System.out.println(totalMinimum);
    }
}