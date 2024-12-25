import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer>[] relationshipList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int nodeNum = input[0];
        int lineNum = input[1];
        int minBaccun = Integer.MAX_VALUE;
        int minBaccunNode = 1;
        relationshipList = new LinkedList[nodeNum + 1];
        for (int i = 0; i < nodeNum + 1; i ++) {
            relationshipList[i] = new LinkedList<>();
        }
        for (int i = 0; i < lineNum; i++) {
            int[] currentLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            relationshipList[currentLine[0]].add(currentLine[1]);
            relationshipList[currentLine[1]].add(currentLine[0]);
        }

        /*
        케빈 베이컨의 수가 가장 작은 사람을 찾으려고 한다
        그런 사람이 여러 명일 경우에는 번호가 가장 작은 사람을 출력
         */

        for (int i = 1; i < nodeNum + 1; i++) {
            LinkedList<Integer>[] copyList = copyRelationshipList(relationshipList, nodeNum + 1);
            int bfsResult = dfs(copyList, i, nodeNum);
            if (bfsResult < minBaccun) {
                minBaccun = bfsResult;
                minBaccunNode = i;
            }
            else if (bfsResult == minBaccun && i < minBaccunNode) 
                minBaccun = bfsResult;
        }

        System.out.println(minBaccunNode);
    }

    private static LinkedList<Integer>[] copyRelationshipList(LinkedList<Integer>[] original, int size) {
        LinkedList<Integer>[] copy = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            copy[i] = new LinkedList<>(original[i]);  // 각 LinkedList를 새로 생성하여 복사
        }
        return copy;
    }

    private static int dfs(LinkedList<Integer>[] copyList, int startNum, int nodeNum) {

        int totalBaccun = 0;
        int currentDepth = 0;
        int[] depthList = new int[nodeNum + 1];
        boolean[] isVisitedList = new boolean[nodeNum + 1];
        Deque<Integer> currentTernal = new ArrayDeque<>();
        currentTernal.add(startNum);

        // 그럼 내가 더 깊숙히 들어갔다는 표시는 어떻게 하지?
        while (currentTernal.size() != 0) {
            int currentVisitedNode = currentTernal.poll();
            currentDepth = depthList[currentVisitedNode] + 1;
            if (!isVisitedList[currentVisitedNode]) {
                isVisitedList[currentVisitedNode] = true;
                while (copyList[currentVisitedNode].size() != 0) {
                    int connectNode = copyList[currentVisitedNode].poll();
                    if (connectNode != startNum) {
                        if (depthList[connectNode] == 0)
                            depthList[connectNode] = currentDepth;
                        else if (depthList[connectNode] > currentDepth)
                            depthList[connectNode] = currentDepth;
                    }

                    currentTernal.add(connectNode);
                }
            }
        }

        for (int i : depthList)
            totalBaccun += i;

        return totalBaccun;
    }
}