
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        dp..?
        N이 1일 경우
        0, 0 -> 0, 1 -> 1, 0 -> 1, 1
        N이 2일 경우
        0, 0 -> 1, 0 -> 0, 1 -> 1, 1 ->
        2, 0 -> 3, 0 -> 2, 1 -> 2, 3 ->
        0, 2 -> 1, 2 -> 0, 3 -> 1, 3 ->
        2, 2 -> 3, 2 -> 2, 3 -> 3, 3

        하나의 규칙이 끝나면 Row + Column의 값이 적은 곳으로 가는데, 이떄 Row값이 적은 곳으로 먼저 뻗는다.

         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int squareLength = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int minimumNum = squareLength / 2;
        int quarterSplit;
        int result = 0;
        while (true) {
            if (column >= minimumNum && row >= minimumNum) {
                quarterSplit = 3;
                column -= minimumNum;
                row -= minimumNum;
            }
            else if (column >= minimumNum && row < minimumNum) {
                quarterSplit = 2;
                column -= minimumNum;
            }
            else if (column < minimumNum && row >= minimumNum) {
                quarterSplit = 1;
                row -= minimumNum;
            }
            else
                quarterSplit = 0;
            result += minimumNum * minimumNum * quarterSplit;
            minimumNum /= 2;
            if (minimumNum == 0)
                break;
        }
        System.out.println(result);
    }
}