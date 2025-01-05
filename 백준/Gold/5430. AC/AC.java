
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        /*
        함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다.
        배열이 비어있는데 D를 사용한 경우에는 에러가 발생
        "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수
         */
        for (int i = 0; i < testCaseNum; i++) {
            String[] executeList = br.readLine().split("");
            int arrayLength = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split("");
            Deque<Integer> array = new LinkedList<>();
            String thisNum = "";
            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("[") || input[j].equals(",") || input[j].equals("]")) {
                    if (thisNum.length() != 0)
                        array.add(Integer.parseInt(thisNum));
                    thisNum = "";
                    continue;
                }
                thisNum += input[j];
            }
            String result = calculate(executeList, array);
            System.out.println(result);
        }
    }

    private static String calculate(String[] executeList, Deque<Integer> array) {
        boolean reverse = false;
        for (int i = 0; i < executeList.length; i++) {
            if (executeList[i].equals("R")) {
                if (reverse)
                    reverse = false;
                else
                    reverse = true;
            }

            else if (executeList[i].equals("D") && array.size() != 0) {
                if (reverse)
                    array.removeLast();
                else
                    array.poll();
            }
            else
                return "error";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (array.size() != 0) {
            if (reverse) {
                int num = array.removeLast();
                if (array.size() == 0) {
                    result.append(num);
                    continue;
                }
                result.append(num + ",");
            }
            else {
                int num = array.poll();
                if (array.size() == 0) {
                    result.append(num);
                    continue;
                }
                result.append(num + ",");
            }
        }
        return result + "]";
    }
}