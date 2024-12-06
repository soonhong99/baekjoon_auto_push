import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int[] stairList = new int[x];
        /*
        계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
        연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
        마지막 도착 계단은 반드시 밟아야 한다.
        계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 구하라

        내가 모든 경우의 수를 따질 수 없다, 아래에서 정해진 것이 위쪽 값의 부분집합인가?

        첫번째 계단을 올랐을 때, 두번째 계단을 올랐을 때 이렇게 나눠서 풀어볼까?
        중간은 상관없는데 끝에머리가 문제야
         */
        for (int i = 0; i < x; i++) {
            int stairScore = Integer.parseInt(br.readLine());
            stairList[i] = stairScore;
        }
        if (x > 1) {
            // 1칸 올라왔는가? 2칸 올라왔는가?
            int[][] dp = new int[x + 1][2];
            // 첫번째 칸은 시작점을 계단으로 치지 않기 때문에 2칸 올라왔다고 가정
            dp[1][1] = stairList[0];
            dp[2][0] = stairList[0] + stairList[1];
            dp[2][1] = stairList[1];

            for (int i = 3; i < x + 1; i++) {
                dp[i][0] = dp[i - 1][1] + stairList[i - 1];
                dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairList[i - 1];
            }
            System.out.println(Math.max(dp[x][0], dp[x][1]));
        }
        else {
            System.out.println(stairList[x - 1]);
        }
    }
}
