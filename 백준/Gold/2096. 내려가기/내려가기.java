
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[][] list = new int[length][3];

        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                list[i][j] = Integer.parseInt(st.nextToken());
        }
        /*
        다음 줄로 내려갈 때에는 다음과 같은 제약 조건이 있다.
        바로 아래의 수로 넘어가거나, 아니면 바로 아래의 수와 붙어 있는 수로만 이동할 수 있다는 것
        가운데에 있을 때는 아래에 있는 아무곳이나 내려갈 수 있다.
        얻을 수 있는 최대 점수, 최소 점수를 구하는 프로그램을 작성하라.
        첫째 줄에 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 숫자가 세 개씩 주어진다.
        숫자는 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 중의 하나가 된다.

        dp 문제이다.
        왜냐하면 일단 주어진 길이가 십만개로, 상당히 많은 편에 속하므로 백트래킹 문제는 될 수 없다.
        최대한 최소의 경로를 갈 수 있는 방법이 존재하지 않으므로 그리디 문제도 아니다.
        BFS 문제인지는 생각을 해봐야 할 것 같다.
        근데 지금 문제가 최대, 최소를 다 구하는 문제라서, 이게 메모리 초과가 발생할 수도 있을 것 같다.
         */

        // dp는 주어진 리스트와 같은 리스트를 필요로 한다.
        int[][] minList = new int[length][3];
        int[][] maxList = new int[length][3];

        for (int i = 0; i < 3; i++) {
            minList[0][i] = list[0][i];
            maxList[0][i] = list[0][i];
        }

        for (int i = 1; i < minList.length; i++) {
            minList[i][0] = Integer.min(minList[i - 1][0], minList[i - 1][1]) + list[i][0];
            minList[i][1] = Integer.min(minList[i - 1][0], Integer.min(minList[i - 1][1], minList[i - 1][2])) + list[i][1];
            minList[i][2] = Integer.min(minList[i - 1][1], minList[i - 1][2]) + list[i][2];

            maxList[i][0] = Integer.max(maxList[i - 1][0], maxList[i - 1][1]) + list[i][0];
            maxList[i][1] = Integer.max(maxList[i - 1][0], Integer.max(maxList[i - 1][1], maxList[i - 1][2])) + list[i][1];
            maxList[i][2] = Integer.max(maxList[i - 1][1], maxList[i - 1][2]) + list[i][2];
        }

        System.out.println(Integer.max(maxList[length - 1][0], Integer.max(maxList[length - 1][1], maxList[length - 1][2])) + " "
                + Integer.min(minList[length - 1][0], Integer.min(minList[length - 1][1], minList[length - 1][2])));
    }
}