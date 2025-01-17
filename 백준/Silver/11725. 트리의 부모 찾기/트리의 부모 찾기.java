
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        /*
        루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
        첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
        형상화 시켜야 되나? 트리자체를?
        입력이 10만이니까, for문 하나로 돌리라는 소리
         */
        int totalNodeNum = Integer.parseInt(br.readLine());
        int[] parentList = new int[totalNodeNum + 1];
        // 1부터 시작이니까
        boolean[] visited = new boolean[totalNodeNum + 1];
        LinkedList<Integer>[] connectNode = new LinkedList[totalNodeNum + 1];
        for (int i = 0; i < totalNodeNum + 1; i++) {
            connectNode[i] = new LinkedList<>();
        }
        for (int i = 0; i < totalNodeNum - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            connectNode[node1].add(node2);
            connectNode[node2].add(node1);
        }
        int currentNode = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        visited[currentNode] = true;
        queue.add(currentNode);

        while (queue.size() != 0) {
            int parentNode = queue.removeFirst();
            LinkedList<Integer> childNodes = connectNode[parentNode];
            while (childNodes.size() != 0) {
                int childNode = childNodes.poll();
                if (!visited[childNode]) {
                    visited[childNode] = true;
                    parentList[childNode] = parentNode;
                    queue.add(childNode);
                }
            }
        }

        // 부모 노드 번호 2번 노드 부터 출력
        for (int i = 2; i < totalNodeNum + 1; i++) {
            System.out.println(parentList[i]);
        }
    }
}