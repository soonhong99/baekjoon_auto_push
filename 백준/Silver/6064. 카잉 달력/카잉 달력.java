
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNum; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int M = input[0];
            int N = input[1];
            int x = input[2];
            int y = input[3];
            if (x == 1 && y == 1) {
                System.out.println(1);
                continue;
            }
            System.out.println(makeCalender(M, N, x, y));
        }
    }

    private static int makeCalender(int M, int N, int x, int y) {
        x--; // 0-based로 변환
        y--;
        int lcm = M * N / gcd(M, N);
        for (int i = x; i < lcm; i += M) {
            if (i % N == y) {
                return i + 1;
            }
        }
        return -1;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}