
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
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int[] givenList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int givenListLength = Integer.parseInt(br.readLine());
        StringTokenizer cutList = new StringTokenizer(br.readLine());
        givenList = new int[givenListLength];
        for (int i = 0; i < givenListLength; i++) {
            givenList[i] = Integer.parseInt(cutList.nextToken());
        }

        int[] LISList = new int[givenListLength];
        for (int currentIndex = 0; currentIndex < givenListLength; currentIndex++) {
            for (int currentUnderIndex = 0; currentUnderIndex < currentIndex; currentUnderIndex++) {
                if (givenList[currentIndex] > givenList[currentUnderIndex])
                    LISList[currentIndex] = Math.max(LISList[currentIndex], LISList[currentUnderIndex] + 1);
            }
        }

        System.out.println(Arrays.stream(LISList).max().getAsInt() + 1);
    }
}