
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
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lengthOfList = Integer.parseInt(st.nextToken());
        int numberOfSolveProblem = Integer.parseInt(st.nextToken());
        int[][] list = new int[lengthOfList + 1][lengthOfList + 1];

        for (int i = 1; i < lengthOfList + 1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j < lengthOfList + 1; j++) {
                list[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int[][] totalAddList = new int[lengthOfList + 1][lengthOfList + 1];

        for (int i = 1; i < lengthOfList + 1; i++) {
            for (int j = 1; j < lengthOfList + 1; j++) {
                totalAddList[i][j] = totalAddList[i][j - 1] + totalAddList[i - 1][j] - totalAddList[i - 1][j - 1] + list[i][j];
            }
        }

        for (int i = 0; i < numberOfSolveProblem; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st3.nextToken());
            int y1 = Integer.parseInt(st3.nextToken());
            int x2 = Integer.parseInt(st3.nextToken());
            int y2 = Integer.parseInt(st3.nextToken());
            System.out.println(totalAddList[x2][y2] - totalAddList[x2][y1 - 1] - totalAddList[x1 - 1][y2] + totalAddList[x1 - 1][y1 - 1]);
        }
    }
}