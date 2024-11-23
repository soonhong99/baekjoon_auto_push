
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        // TODO: 프로그램 구현
        /*
        상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
        설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
        상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다.
        예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
        정확하게 N개의 봉지로 만들 수 없다면 -1 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int canMakeNum = -1;
        int fiveKgNum = 0;

        while (true) {
            int totalKg = N - 5 * fiveKgNum;
            if (totalKg < 0) {
                break;
            }
            if (totalKg % 3 == 0) {
                canMakeNum = fiveKgNum + (totalKg / 3);
            }
            fiveKgNum++;
        }

        System.out.println(canMakeNum);
    }
}
