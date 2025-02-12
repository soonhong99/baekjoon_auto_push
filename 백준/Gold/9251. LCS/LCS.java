
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstInput = br.readLine().split("");
        String[] secondInput = br.readLine().split("");
        int[][] longestSubList = new int[firstInput.length + 1][secondInput.length + 1]; // 1-based

        for (int i = 1; i < firstInput.length + 1; i++) {
            for (int j = 1; j < secondInput.length + 1; j++) {
                if (firstInput[i - 1].equals(secondInput[j - 1]))
                    longestSubList[i][j] = longestSubList[i - 1][j - 1] + 1;
                else
                    longestSubList[i][j] = Math.max(longestSubList[i - 1][j], longestSubList[i][j - 1]);
            }
        }
        System.out.println(longestSubList[firstInput.length][secondInput.length]);
    }
}