
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startNum = Integer.parseInt(st.nextToken());
            int endNum = Integer.parseInt(st.nextToken());

            String result = bfs(startNum, endNum);
            System.out.println(result);
        }
    }

    private static String bfs(int startNum, int endNum) {
        boolean[] visitedList = new boolean[10000];
        String[] DSLRList = new String[10000];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(startNum);
        DSLRList[startNum] = "";

        while (queue.size() != 0) {
            int currentNum = queue.poll();
            visitedList[currentNum] = true;
            String currentDSLR = DSLRList[currentNum];

            // D로 했을 떄 어떤 num이 나오는지 확인 -> visited가 아니라면 ~ DSLR String, queue에 num 추가, visitedList로 선정 총 세가지 작업 필요
            // D
            int addDNum = makeD(currentNum);
            if (!visitedList[addDNum]) {
                DSLRList[addDNum] = currentDSLR + "D";
                queue.add(addDNum);
                visitedList[addDNum] = true;
            }
            // S
            int addSNum = makeS(currentNum);
            if (!visitedList[addSNum]) {
                DSLRList[addSNum] = currentDSLR + "S";
                queue.add(addSNum);
                visitedList[addSNum] = true;
            }
            // L
            int addLNum = makeL(currentNum);
            if (!visitedList[addLNum]) {
                DSLRList[addLNum] = currentDSLR + "L";
                queue.add(addLNum);
                visitedList[addLNum] = true;
            }
            // R
            int addRNum = makeR(currentNum);
            if (!visitedList[addRNum]) {
                DSLRList[addRNum] = currentDSLR + "R";
                queue.add(addRNum);
                visitedList[addRNum] = true;
            }

            if (addDNum == endNum || addSNum == endNum || addLNum == endNum || addRNum == endNum)
                break;
        }

        return DSLRList[endNum];
    }

    private static int makeD(int num) {
        //D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다.
        // 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
        int thisNum = num * 2;
        if (thisNum >= 10000) {
            return thisNum % 10000;
        }
        return thisNum;
    }

    private static int makeS(int num) {
        // S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
        if (num == 0)
            return 9999;
        return num - 1;
    }

    private static int makeL(int num) {
        return (num % 1000) * 10 + num / 1000;
    }

    private static int makeR(int num) {
        return (num % 10) * 1000 + num / 10;
    }
}