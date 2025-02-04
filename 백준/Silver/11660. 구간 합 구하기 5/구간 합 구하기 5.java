
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.Inet4Address;
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
    static int[][] list;
    static int[][] cumulativeList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000)
        둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
        다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다.
        표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int listLength = Integer.parseInt(st.nextToken());
        int executionNum = Integer.parseInt(st.nextToken());
        list = new int[listLength + 1][listLength + 1];
        cumulativeList = new int[listLength + 1][listLength + 1];
        for (int i = 1; i < listLength + 1; i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int j = 1; j < listLength + 1; j++) {
                list[i][j] = Integer.parseInt(row.nextToken());
            }
        }

        /*
        1 2 3 4 5
        2 3 4 5 6
        3 4 5 6 7
        4 5 6 7 8
        5 6 7 8 9
         */

        for (int i = 1; i < listLength + 1; i++) {
            for (int j = 1; j < listLength + 1; j++) {
                cumulativeList[i][j] = cumulativeList[i - 1][j] + cumulativeList[i][j - 1] - cumulativeList[i - 1][j - 1] + list[i][j];
            }
        }

        for (int i = 0; i < executionNum; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(nums.nextToken());
            int y1 = Integer.parseInt(nums.nextToken());
            int x2 = Integer.parseInt(nums.nextToken());
            int y2 = Integer.parseInt(nums.nextToken());

            int totalNum = cumulativeList[x2][y2] - cumulativeList[x1 - 1][y2] - cumulativeList[x2][y1 -1] + cumulativeList[x1- 1][y1 -1];
            System.out.println(totalNum);
        }
    }
}