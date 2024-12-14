
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
        int input = Integer.parseInt(br.readLine());
        int[] dp = makeDp(input);
        System.out.println(dp[input]);
    }

    private static int[] makeDp(int num) {
        // 자연수 n이 주어질 때, n을 최소 개수의 제곱수 합으로 표현하는 컴퓨터 프로그램을 작성하라
        int[] dp = new int[num + 1];
        Arrays.fill(dp, 50001);
        dp[0] = 0;

        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                int val = j * j;
                if (val > i)
                    break;
                dp[i] = Math.min(dp[i], dp[i - val] + 1);
            }
        }
        return dp;
    }
}