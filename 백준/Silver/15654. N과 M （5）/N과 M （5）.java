
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


//public class Application {
//    static int len;
//    static int maxListLength;
//    static int[] sortedlist;
//    static int[] notPerfectedList;
//    static int[] visitedList;
//    static StringBuilder sb;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        sb = new StringBuilder();
//        len = Integer.parseInt(st.nextToken());
//        maxListLength = Integer.parseInt(st.nextToken());
//        StringTokenizer randomOrderInput = new StringTokenizer(br.readLine());
//        sortedlist = new int[len];
//        notPerfectedList = new int[len];
//        visitedList = new int[len];
//        for (int i = 0; i < len; i++) {
//            sortedlist[i] = Integer.parseInt(randomOrderInput.nextToken());
//        }
//        Arrays.sort(sortedlist);
//        dfs(0);
//        System.out.println(sb.toString());
//    }
//
//    private static void dfs(int index) {
//        if (index == maxListLength) {
//            for (int i : notPerfectedList) {
//                sb.append(i + " ");
//            }
//            sb.append("\n");
//            return;
//        }
//
//        /*
//        왜 이 for문은 0부터 시작해야되는지도 모르겠고, visitedList의 해당 인덱스가 0으로 다시 바뀌어야되는지도 모르겠다.
//        for 문이 0부터 시작하는 이유: 결국에는 나중에 맨 앞에 맨뒤 인덱스 값이 들어갈 수 있는데,
//        그렇게 됐을 때 0부터 확인 해야지 모든 인덱스 값을 집어넣을 수 있다.
//        visitedList의 값이 0이 되어야 하는 이유는, 이후 백트래킹때 적용이 되면 안되기 때문이다.
//         */
//
//        for (int currentIndex = 0; currentIndex < maxListLength; currentIndex++) {
//            if (visitedList[currentIndex] == 0) {
//                visitedList[currentIndex] = 1;
//                notPerfectedList[index] = sortedlist[currentIndex];
//                dfs(index + 1);
//                visitedList[currentIndex] = 0;
//            }
//        }
//    }
//}

public class Main {
    static int[] list;
    static int listLength;
    static int totalListNum;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        totalListNum = Integer.parseInt(st.nextToken());
        listLength = Integer.parseInt(st.nextToken());
        list = new int[totalListNum];
        int[] makingList = new int[listLength];
        boolean[] visitedList = new boolean[totalListNum];
        StringTokenizer input = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < totalListNum; i++)
            list[i] = Integer.parseInt(input.nextToken());
        Arrays.sort(list);

        // currentDepth, visitedList, makingList
        backTracking(0, visitedList, makingList);
        System.out.println(sb);
    }

    private static void backTracking(int currentDepth, boolean[] visitedList, int[] makingList) {
        if (currentDepth == listLength) {
            for (int i: makingList)
                sb.append(i + " ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < totalListNum; i++) {
            if (!visitedList[i]) {
                visitedList[i] = true;
                makingList[currentDepth] = list[i];
                backTracking(currentDepth + 1, visitedList, makingList);
                visitedList[i] = false;
            }
        }
    }
}