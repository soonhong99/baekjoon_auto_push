
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] treesLength = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int treeNum = input[0];
        int needTreeLength = input[1];
        Arrays.sort(treesLength);
        long rightTreeLength = treesLength[treesLength.length - 1];
        long leftTreeLength = 0;
        long answer = 0;
        while (leftTreeLength <= rightTreeLength) {
            long totalCutLength = 0;
            long middleLength = (leftTreeLength + rightTreeLength) / 2;
            for (int i : treesLength) {
                long cutLength = i - middleLength;
                if (cutLength < 0)
                    continue;
                totalCutLength += cutLength;
            }
            if (totalCutLength >= needTreeLength) {
                answer = middleLength;
                leftTreeLength = middleLength + 1;
            }
            else
                rightTreeLength = middleLength - 1;
        }

        System.out.println(answer);
    }
}