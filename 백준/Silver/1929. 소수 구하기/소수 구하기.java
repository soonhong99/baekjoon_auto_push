import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 3, 16
        int start = input[0];
        int end = input[1];
        if (start == 1) {
            start = 2;
        }
        for (int i = start; i <= end; i++) {
            int sqrtNum = (int) Math.sqrt(i);
            boolean isPrime = true;
            if (sqrtNum < 2) {
                System.out.println(i);
                continue;
            }
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}
