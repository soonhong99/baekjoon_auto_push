
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
    static int[] givenList;
    static boolean[] used;
    static int findListLength;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int givenListLength = Integer.parseInt(st.nextToken());
        findListLength = Integer.parseInt(st.nextToken());
        StringTokenizer givenListString = new StringTokenizer(br.readLine());
        givenList = new int[givenListLength];
        sb = new StringBuilder();
        int[] findList = new int[findListLength];
        used = new boolean[givenListLength];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < givenListLength; i++) {
            // givenList[i] = Integer.parseInt(givenListString.nextToken());
            set.add(Integer.parseInt(givenListString.nextToken()));
        }
        givenList = set.stream().mapToInt(Integer::intValue).toArray();
        /*
        한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
        중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
        수열은 사전 순으로 증가하는 순서로 출력해야 한다.
         */

        Arrays.sort(givenList);
        backTracking(0, findList, -1);
        System.out.print(sb);
    }

    private static void backTracking(int depth, int[] findList, int currentNum) {
        if (depth == findListLength) {
            for (int i : findList) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < givenList.length; i++) {
            if (givenList[i] >= currentNum) {
                findList[depth] = givenList[i];
                currentNum = givenList[i];
                backTracking(depth + 1, findList, currentNum);
            }
        }
    }

}