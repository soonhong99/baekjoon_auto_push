
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
    static int limitNum;
    static int length;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limitNum = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        arr = new int[length];

        dfs(1, 0);
    }

    // depth를 알고 있어야 한다, 해당 depth의 인자값을 알고있어야 한다.
    private static void dfs(int currentNum, int currentDepth) {
        if (currentDepth == length) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = currentNum; i <= limitNum; i++) {
            arr[currentDepth] = i;
            dfs(i + 1, currentDepth + 1);
        }
    }
}
