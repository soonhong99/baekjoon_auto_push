
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int nodeNum = input[0];
        int lineNum = input[1];
        int startNodeNum = input[2];
        int[][] lineList = new int[lineNum][2];

        for (int i = 0; i < lineNum; i++) {
            int[] nodeLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            lineList[i][0] = nodeLine[0];
            lineList[i][1] = nodeLine[1];
        }

        int[] dfsResult = dfs(lineList, startNodeNum, lineNum, nodeNum);
        int[] bfsResult = bfs(lineList, startNodeNum, lineNum, nodeNum);


        for (int i : dfsResult) {
            if (i == 0)
                continue;
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : bfsResult) {
            if (i == 0)
                continue;
            System.out.print(i + " ");
        }
    }

    private static int[] bfs(int[][] lineList, int startNodeNum, int lineNum, int nodeNum) {
        int[] visitedNodeList = new int[nodeNum];
        LinkedList<Integer>[] linkedNode = new LinkedList[nodeNum + 1];
        for (int i = 0; i <= nodeNum; i++) {
            linkedNode[i] = new LinkedList<>();
        }
        boolean[] isConnectList = new boolean[nodeNum + 1];
        Deque<Integer> bfsList = new ArrayDeque<>();

        for (int i = 0; i < lineNum; i++) {
            linkedNode[lineList[i][0]].add(lineList[i][1]);
            linkedNode[lineList[i][1]].add(lineList[i][0]);
        }

        visitedNodeList[0] = startNodeNum;
        int nextVistIndex = 1;
        isConnectList[startNodeNum] = true;
        bfsList.add(startNodeNum);

        while (bfsList.size() != 0) {
            int watchingNum = bfsList.removeFirst();
            if (isConnectList[watchingNum] == false) {
                isConnectList[watchingNum] = true;
                visitedNodeList[nextVistIndex] = watchingNum;
                nextVistIndex++;
            }
            while (linkedNode[watchingNum].size() != 0) {
                Collections.sort(linkedNode[watchingNum]);
                bfsList.add(linkedNode[watchingNum].poll());
            }
        }

        return visitedNodeList;
    }

    private static int[] dfs(int[][] lineList, int startNodeNum, int lineNum, int nodeNum) {
        int[] resultList = new int[nodeNum];

        LinkedList<Integer>[] linkedNodeList = new LinkedList[nodeNum + 1];
        for (int i = 0; i <= nodeNum; i++) {
            linkedNodeList[i] = new LinkedList<>();
        }
        boolean[] isVisitedList = new boolean[nodeNum + 1];
        Deque<Integer> dfsList = new ArrayDeque<>();

        int nextVistIndex = 0;
        dfsList.add(startNodeNum);

        for (int i = 0; i < lineNum; i++) {
            linkedNodeList[lineList[i][0]].add(lineList[i][1]);
            linkedNodeList[lineList[i][1]].add(lineList[i][0]);
        }

        while (dfsList.size() != 0) {
            int watchingNum = dfsList.removeLast();
            Collections.sort(linkedNodeList[watchingNum], Collections.reverseOrder());

            if (!isVisitedList[watchingNum]) {
                isVisitedList[watchingNum] = true;
                resultList[nextVistIndex] = watchingNum;
                nextVistIndex++;

                for (int linkedNode : linkedNodeList[watchingNum]) {
                    if (isVisitedList[linkedNode] == false)
                        dfsList.add(linkedNode);
                }
            }
        }

        return resultList;
    }
}