
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int alreadyHaveLanNum;
        int needLanNum;

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        alreadyHaveLanNum = input[0];
        needLanNum = input[1];
        int[] lanLengthList = new int[alreadyHaveLanNum];
        for (int i = 0; i < alreadyHaveLanNum; i++) {
            int lanLength = Integer.parseInt(br.readLine());
            lanLengthList[i] = lanLength;
        }
        System.out.println(calculateMaxLength(alreadyHaveLanNum, lanLengthList, needLanNum));
    }

    public static long calculateMaxLength(int alreadyHaveLanNum, int[] lanLengthList, int needLanNum) {
        long left = 1;
        long right = Integer.MAX_VALUE;

        while (left <= right) {
            int count = 0;
            long mid = (left + right) / 2;
            for (int i = 0; i < alreadyHaveLanNum; i++)
                count += lanLengthList[i] / mid;
            if (count < needLanNum)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return right;
    }
}
