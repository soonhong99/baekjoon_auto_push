
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {
    static int maxNum;
    static int listMaxLength;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        maxNum = Integer.parseInt(st.nextToken());
        listMaxLength = Integer.parseInt(st.nextToken());
        list = new int[listMaxLength];
        // 같은 수를 여러번 골라도 된다.
        dfs(1, 0);
    }

    private static void dfs(int currentNum, int currentDepth) {
        if (currentDepth == listMaxLength) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = currentNum; i <= maxNum; i++) {
            list[currentDepth] = i;
            dfs(i, currentDepth + 1);
        }
    }
}
