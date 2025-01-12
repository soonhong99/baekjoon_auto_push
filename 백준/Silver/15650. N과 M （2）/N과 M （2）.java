
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
    static int[] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M]; // depth를 구하는거니까

        dfs(1, 0);
    }

    private static void dfs(int at, int depth) {
        /*
        1,0 들어갔어 -> arr 첫 인덱스에 1이 들어가 -> dfs에 2,1이 들어가 -> 두번째 인덱스에 2가 들어가
                  -> i가 1 증가해서 첫 인덱스에 2가 들어가 -> dfs에 3, 1이 들어가 -> 두번째 인덱스에 3이 들어가
        이게 어케 DFS인걸 알지?
         */
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
