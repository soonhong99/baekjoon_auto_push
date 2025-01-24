
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int triLength = Integer.parseInt(br.readLine());
        int[][] triExpense = new int[triLength][triLength];
        int[][] maxExpense = new int[triLength][triLength];
        for (int i = 0; i < triLength; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                triExpense[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        /*
        이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라.
        아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
        삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

        dp로 풀어보자. BFS로 하려고 하니까 삼각형 모양을 구현하는게 쉽지 않을 것 같다.
         */

        // 아래서부터 시작
        for (int i = 0; i < triLength; i++) {
            maxExpense[0][i] = triExpense[triLength - 1][i];
        }
        if (triLength == 1) {
            System.out.println(maxExpense[0][0]);
            return;
        }
        for (int i = 1; i < triLength; i++) {
            for (int j = 0; j < triLength - i; j++) {
                maxExpense[i][j] = Math.max(maxExpense[i - 1][j],
                        maxExpense[i - 1][j + 1]) + triExpense[triLength - i - 1][j];
            }
        }
        System.out.println(maxExpense[triLength - 1][0]);
    }
}