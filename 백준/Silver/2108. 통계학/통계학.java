
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

        둘째 줄에는 중앙값을 출력한다.

        셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

        넷째 줄에는 범위를 출력한다.
         */
        int runTime = Integer.parseInt(br.readLine());
        ArrayList<Integer> inputList = new ArrayList<>();
        int[] sameNumbers = new int[8001];
        int addAllValue = 0;
        for (int i = 0; i < runTime; i++) {
            Integer input = Integer.valueOf(br.readLine());
            addAllValue += input;
            inputList.add(input);
            sameNumbers[input + 4000] += 1;
        }
        int listLength = runTime;
        List<Integer> sortedInputList = inputList.stream().sorted().collect(Collectors.toList());
        Integer halfValue = sortedInputList.get(runTime / 2);
        System.out.println((int) Math.round((double) addAllValue / listLength));
        System.out.println(halfValue);
        // 1 1 3 3 5
        // 1 1 3 4 5
        // 최빈값이 여러개인지 판단하는 방법?
        int mostDuplicate = 1;
        int mostDuplicateNum = -9999;
        int twoSmallest = 0;
        for (int i = 0; i < sameNumbers.length; i++) {
            if (sameNumbers[i] > mostDuplicate) {
                mostDuplicateNum = i - 4000;
                mostDuplicate = sameNumbers[i];
                twoSmallest = 1;
            }
            else if (sameNumbers[i] == mostDuplicate) {
                twoSmallest++;
                if (twoSmallest == 2) {
                    mostDuplicateNum = i - 4000;
                }
            }
        }
        if (listLength == 1) {
            System.out.println(sortedInputList.get(0));
        }
        else {
            System.out.println(mostDuplicateNum);
        }
        if (sortedInputList.size() != 1) {
            System.out.println(sortedInputList.get(listLength - 1) - sortedInputList.get(0));
        }
        else {
            System.out.println(0);
        }
    }
}
