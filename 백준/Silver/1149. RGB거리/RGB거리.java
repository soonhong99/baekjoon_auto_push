
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
    static int[][] RGBExpenses;
    static int[][] totalMinRgbExpenses;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int houseNum = Integer.parseInt(br.readLine());
        RGBExpenses = new int[houseNum][3];
        totalMinRgbExpenses = new int[houseNum][3];

        for (int i = 0; i < houseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int colorExpense = Integer.parseInt(st.nextToken());
                RGBExpenses[i][j] = colorExpense;
            }
        }
        totalMinRgbExpenses[0][0] = RGBExpenses[0][0];
        totalMinRgbExpenses[0][1] = RGBExpenses[0][1];
        totalMinRgbExpenses[0][2] = RGBExpenses[0][2];

        for (int i = 1; i < houseNum; i++) {
            totalMinRgbExpenses[i][0] = Math.min(totalMinRgbExpenses[i - 1][1], totalMinRgbExpenses[i - 1][2]) + RGBExpenses[i][0];
            totalMinRgbExpenses[i][1] = Math.min(totalMinRgbExpenses[i - 1][0], totalMinRgbExpenses[i - 1][2]) + RGBExpenses[i][1];
            totalMinRgbExpenses[i][2] = Math.min(totalMinRgbExpenses[i - 1][0], totalMinRgbExpenses[i - 1][1]) + RGBExpenses[i][2];
        }
        System.out.println(Arrays.stream(totalMinRgbExpenses[totalMinRgbExpenses.length - 1]).min().getAsInt());
    }
}