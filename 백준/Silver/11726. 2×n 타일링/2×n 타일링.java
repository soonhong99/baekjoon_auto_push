
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
        int rectangularSize = Integer.parseInt(br.readLine());
        // 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
        System.out.println(makeWithInitialRectangular(rectangularSize) % 10007);
    }

    private static long makeWithInitialRectangular(int rectangularSize) {
        /*
        2*1 직사각형은 누울 수 있고, 세울 수 있는 두가지 경우의 수가 존재한다.
        2가 몇개 오느냐에 따라 나눌 수 있다.
        1의 경우
        1
        2의 경우
        11 2
        3의 경우
        12 21 111
        4의 경우
        112 121 211 22 1111
        5의 경우
        1112 1121 1211 2111 221 212 122 11111
        6의 경우
        111111 11112 11121 11211 12111 21111 1122 1212 2112 1221 2211 222
        */
        ArrayList<Long> recList = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        if (rectangularSize <= 3) {
            return recList.get(rectangularSize - 1);
        }
        for (int i = 3; i < rectangularSize; i++) {
            long beforeBeforeNum = recList.get(i - 2);
            long beforeNum = recList.get(i - 1);
            recList.add(beforeNum + beforeBeforeNum % 10007);
        }
        return recList.get(rectangularSize - 1);
    }
}