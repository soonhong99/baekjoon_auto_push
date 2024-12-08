
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseNum = Integer.parseInt(br.readLine());
        // 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수
        for (int i = 0; i < caseNum; i++) {
            System.out.println(makeWithOneTwoThree(Integer.parseInt(br.readLine())));
        }
    }

    /*
    1이 2가 되고, 3이된 것을 함수화?
     */
    private static int makeWithOneTwoThree(int num) {
        int changeTotalnum = num;
        int one = num;
        int two = 0;
        int three = 0;
        int total = 0;
        // 2의 개수 최대치, 3의 개수 최대치 이런식으로?
        // 근데 3의 개수를 할 때 2의 개수 최대치가 들어가네?
        // 3을 추가하면 2의 개수를 기준점으로 또 나눌 수 있다.
        // 그니까 3이 아예 없을 때, 그리고 3이 1개 있을 때 .. 이런식으로 기준을 책정해야되나?
        while (true) {
            if (one < 0)
                break;
            total += makeWithThree(changeTotalnum, one, two, three);
            three++;
            one = num - 3 * three;
            two = 0;
            changeTotalnum -= 2;
        }
        return total;
    }

    private static int makeWithThree(int num, int one, int two, int three) {
        int total = 0;
        while (true) {
            if (one < 0)
                break;
            total += factorial(num) / (factorial(one) * factorial(two) * factorial(three));
            one -= 2;
            num--;
            two++;
        }
        return total;
    }

    private static int factorial(int num) {
        if (num == 0)
            return 1;
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}