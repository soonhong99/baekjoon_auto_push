
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    static LinkedList<Integer>[] linkedNodeList;
    static ArrayList<Integer> allNodeList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int nodeNum = input[0];
        int lineNum = input[1];
        linkedNodeList = new LinkedList[nodeNum + 1];
        for (int i = 1; i < nodeNum + 1; i++) {
            linkedNodeList[i] = new LinkedList<>();
        }
        allNodeList = new ArrayList<>();
        for (int i = 0; i < lineNum; i++) {
            int[] linkNodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!allNodeList.contains(linkNodes[0]))
                allNodeList.add(linkNodes[0]);
            if (!allNodeList.contains(linkNodes[1]))
                allNodeList.add(linkNodes[1]);
            linkedNodeList[linkNodes[0]].add(linkNodes[1]);
            linkedNodeList[linkNodes[1]].add(linkNodes[0]);
        }
        System.out.println(calSetNum(nodeNum));
    }

    private static int calSetNum(int nodeNum) {
        // 남은거를 어떻게 찾을까?
        int setNum = 0;
        boolean[] isvisitedList = new boolean[nodeNum + 1];
        while (allNodeList.size() != 0) {
            int startNum = allNodeList.get(0);
            if (isvisitedList[startNum]) {
                allNodeList.remove(0);
                continue;
            }
            setNum++;
            Deque<Integer> saveNextMoveNode = new ArrayDeque<>();
            saveNextMoveNode.add(startNum);
            while (saveNextMoveNode.size() != 0) {
                startNum = saveNextMoveNode.poll();
                isvisitedList[startNum] = true;
                int linkedNodeNum = linkedNodeList[startNum].size();
                for (int i = 0; i < linkedNodeNum; i++) {
                    int gogo = linkedNodeList[startNum].poll();
                    if (isvisitedList[gogo] == false) {
                        saveNextMoveNode.add(gogo);
                        isvisitedList[gogo] = true;
                    }
                }
            }
        }

        for (int i = 1; i < isvisitedList.length; i++) {
            if (isvisitedList[i] == false)
                setNum++;
        }
        return setNum;
    }
}