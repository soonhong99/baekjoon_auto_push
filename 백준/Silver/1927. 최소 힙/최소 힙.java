
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
    static PriorityQueue<Integer> list = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int calNum = Integer.parseInt(br.readLine());
        // 만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
        // x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우
        for (int i = 0; i < calNum; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (list.size() == 0) {
                    System.out.println(0);
                }
                else {
                    System.out.println(list.poll());
                }
            }
            else {
                putNumToTheList(input);
            }
        }
    }

    private static void putNumToTheList(int input) {
        list.add(input);
    }
}