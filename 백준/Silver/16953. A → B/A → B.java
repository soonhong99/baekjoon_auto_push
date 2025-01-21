
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static long startNum;
    static long endNum;
    static long processNum;
    static long result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

        2를 곱한다.
        1을 수의 가장 오른쪽에 추가한다.
        A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

        입력
        첫째 줄에 A, B (1 ≤ A < B ≤ 10^9)가 주어진다.

        출력
        A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.

        예시 (2, 162 -> 5)
        2 → 4 → 8 → 81 → 162

        bfs는 아니야. 왜냐하면 못들어갈 수 있는 경우의 수가 있기 때문이다.
        dp인가? ->
        백트래킹인가? -> 순차적으로 나열하는 것도 아니고, 넘어가는 것과 안넘어가는 것 구분을 할 수 없으므로 백트래킹도 아니다.
        브루트포스인가? ->
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        startNum = Integer.parseInt(st.nextToken());
        endNum = Integer.parseInt(st.nextToken());
        processNum = startNum;

        dfs();

        System.out.println(result);
    }

    private static void dfs() {
        int depth = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(startNum, depth);
        Deque<Long> queue = new ArrayDeque<>();
        queue.add(startNum);
        boolean find = false;

        // depth도 저장해야돼
        while (queue.size() != 0) {
            processNum = queue.removeLast();
            int momDepth = map.get(processNum);
            if (processNum == endNum && result > momDepth + 1) {
                result = momDepth + 1;
                find = true;
            }

            long doubleSize = processNum * 2;
            if (doubleSize <= endNum) {
                queue.add(doubleSize);
                map.put(doubleSize, momDepth + 1);
            }


            long addOne = processNum * 10 + 1;
            if (addOne <= endNum) {
                queue.add(addOne);
                map.put(addOne, momDepth + 1);
            }
        }
        if (!find)
            result = -1;
    }
}