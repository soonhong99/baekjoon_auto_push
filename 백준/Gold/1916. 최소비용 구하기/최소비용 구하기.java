import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static LinkedList<int[]>[] busList;
    static boolean[] visitedList;
    static int[] expenseList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());
        busList = new LinkedList[cityNum + 1];
        visitedList = new boolean[cityNum + 1];
        expenseList = new int[cityNum + 1];
        Arrays.fill(expenseList, Integer.MAX_VALUE);

        for (int i = 1; i < cityNum + 1; i++)
            busList[i] = new LinkedList<>();

        for (int i = 0; i < busNum; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st2.nextToken());
            int endCity = Integer.parseInt(st2.nextToken());
            int busExpense = Integer.parseInt(st2.nextToken());
            busList[startCity].add(new int[]{endCity, busExpense});
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int startCityToSolve = Integer.parseInt(st3.nextToken());
        int endCityToSolve = Integer.parseInt(st3.nextToken());

        int totalExpense = dijkstra(startCityToSolve, endCityToSolve);
        System.out.println(totalExpense);
    }

    private static int dijkstra(int start, int end) {
        expenseList[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentExpense = current[0];
            int currentNode = current[1];

            if (visitedList[currentNode]) continue;
            visitedList[currentNode] = true;

            for (int[] neighborNodeAndExpense : busList[currentNode]) {
                int neighborNode = neighborNodeAndExpense[0];
                int neighborExpense = neighborNodeAndExpense[1];

                if (!visitedList[neighborNode] && currentExpense + neighborExpense < expenseList[neighborNode]) {
                    expenseList[neighborNode] = currentExpense + neighborExpense;
                    pq.add(new int[]{expenseList[neighborNode], neighborNode});
                }
            }
        }
        return expenseList[end];
    }
}