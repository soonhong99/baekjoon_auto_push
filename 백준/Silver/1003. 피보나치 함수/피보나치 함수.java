
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numOfStart = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfStart; i++) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
        }
    }
    /*
    0 -> 1, 0
    1 -> 0, 1
    2 -> 1, 1
    3 -> 1, 2
    4 -> 2, 3
    5 -> 3, 5
     */
    private static void fibonacci(int N) {
        int zeroCount = 0;
        int oneCount = 0;
        if (N == 0) {
            System.out.println("1 0");
            return;
        }
        else if (N == 1) {
            System.out.println("0 1");
            return;
        }
        int[][] fiboList = new int[N + 1][2];
        fiboList[0][0] = 1;
        fiboList[0][1] = 0;
        fiboList[1][0] = 0;
        fiboList[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            fiboList[i][0] = fiboList[i - 1][0] + fiboList[i - 2][0];
            fiboList[i][1] = fiboList[i - 2][1] + fiboList[i - 1][1];
        }
        System.out.println(fiboList[N][0] + " " + fiboList[N][1]);
    }
}
