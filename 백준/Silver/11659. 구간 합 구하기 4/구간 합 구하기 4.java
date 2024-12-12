
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int caseNum = input[1];
        int[] numList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] addNumList = calculateTotalSumList(numList);
        for (int i = 0; i < caseNum; i++) {
            int[] startAndEndIndex = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startIndex = startAndEndIndex[0];
            int endIndex = startAndEndIndex[1];
            if (startIndex == 1) {
                bw.write(String.valueOf(addNumList[endIndex] + "\n"));
            }
            else
                bw.write(String.valueOf(addNumList[endIndex] - addNumList[startIndex - 1]) + "\n");
        }
        bw.flush();
    }

    private static long[] calculateTotalSumList(int[] numList) {
        long[] totalSumList = new long[numList.length + 1];

        totalSumList[0] = 0;

        for (int i = 1; i < totalSumList.length; i++) {
            totalSumList[i] += numList[i - 1] + totalSumList[i - 1];
        }

        return totalSumList;
    }

    private static long countTotalNum(int[] numList, int startIndex, int endIndex) {
        long totalNum = 0;

        for (int i = startIndex - 1; i < endIndex; i++) {
            totalNum += numList[i];
        }

        return totalNum;
    }
}