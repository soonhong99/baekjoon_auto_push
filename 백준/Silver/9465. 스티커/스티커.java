
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.Inet4Address;
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
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNum; i++) {
            int rowLength = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] stickerList = new int[2][rowLength];
            for (int j = 0; j < rowLength; j++) {
                stickerList[0][j] = Integer.parseInt(st.nextToken());
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < rowLength; j++) {
                stickerList[1][j] = Integer.parseInt(st2.nextToken());
            }

            if (rowLength == 1) {
                System.out.println(Math.max(stickerList[0][0], stickerList[1][0]));
                continue;
            }
            
            if (rowLength == 2) {
                System.out.println(Math.max(stickerList[0][0] + stickerList[1][1], stickerList[0][1] + stickerList[1][0]));
                continue;
            }

            int[][] maxList = new int[2][rowLength];
            maxList[0][0] = stickerList[0][0];
            maxList[1][0] = stickerList[1][0];
            maxList[0][1] = maxList[1][0] + stickerList[0][1];
            maxList[1][1] = maxList[0][0] + stickerList[1][1];

            for (int j = 2; j < rowLength; j++) {
                maxList[0][j] = Math.max(maxList[0][j - 2], Math.max(maxList[1][j - 2], maxList[1][j - 1])) + stickerList[0][j];
                maxList[1][j] = Math.max(maxList[0][j - 2], Math.max(maxList[1][j - 2], maxList[0][j - 1])) + stickerList[1][j];
            }
            System.out.println(Math.max(Math.max(maxList[0][rowLength - 2], maxList[0][rowLength - 1]), Math.max(maxList[1][rowLength - 2], maxList[1][rowLength - 1])));
            /*
            10 50 60 130 210 210 270
            20 50 80 110 190 230 290
             */
        }
    }
}