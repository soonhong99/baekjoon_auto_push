
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalStairNum = Integer.parseInt(br.readLine());
        int[] stairScore = new int[totalStairNum];
        for (int i = 0; i < totalStairNum; i++) {
            stairScore[i] = Integer.parseInt(br.readLine());
        }
        if (totalStairNum != 1) {
            int[][] oneOrTwoUpList = new int[totalStairNum + 1][2];

            oneOrTwoUpList[1][1] = stairScore[0];
            oneOrTwoUpList[2][0] = stairScore[0] + stairScore[1];
            oneOrTwoUpList[2][1] = stairScore[1];
            for (int i = 3; i < totalStairNum + 1; i++) {
                // 한칸만 올라왔을 경우에 그 전 계단에서 2칸 떨어지는 경우의 수만 존재한다.
                oneOrTwoUpList[i][0] = oneOrTwoUpList[i - 1][1] + stairScore[i - 1];
                // 2칸 올라왔을 경우 두칸 전에 1칸을 올라오든, 2칸을 띄어서 올라오든 상관없다.
                oneOrTwoUpList[i][1] = Math.max(oneOrTwoUpList[i - 2][0], oneOrTwoUpList[i - 2][1]) + stairScore[i - 1];
            }
            System.out.println(Math.max(oneOrTwoUpList[totalStairNum][0], oneOrTwoUpList[totalStairNum][1]));
        } else {
            System.out.println(stairScore[0]);
        }
    }
}
