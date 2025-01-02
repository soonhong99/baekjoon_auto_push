
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    static LinkedList<Integer>[] linkedLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineNum = Integer.parseInt(br.readLine());
        // 방향 그래프
        linkedLists = new LinkedList[lineNum];
        for (int i = 0; i < lineNum; i++) {
            linkedLists[i] = new LinkedList<>();
        }
        for (int i = 0; i < lineNum; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < lineNum; j++) {
                if (input[j] == 1)
                    linkedLists[i].add(j);
            }
        }

        for (int i = 0; i < lineNum; i++) {
            StringBuilder currentRow = new StringBuilder();
            for (int j = 0; j < lineNum; j++) {
//                if (i == j) {
//                    currentRow.append(1 + " ");
//                    continue;
//                }
                currentRow.append(bfs(i, j) + " ");
            }
            System.out.println(currentRow);
        }
    }

    private static int bfs(int start, int end) {
        LinkedList<Integer>[] copyLists = new LinkedList[linkedLists.length];
        for (int i = 0; i < copyLists.length; i++) {
            copyLists[i] = new LinkedList<>(linkedLists[i]);
        }
        boolean findEndNode = false;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        int cycle = 0;

        while (deque.size() != 0) {
            int currentNode = deque.removeFirst();
            if (currentNode == end && cycle != 0) {
                findEndNode = true;
                break;
            }
            while (copyLists[currentNode].size() != 0) {
                int nearNode = copyLists[currentNode].removeFirst();
                deque.add(nearNode);
            }
            cycle++;
        }
        if (findEndNode)
            return 1;
        return 0;
    }
}