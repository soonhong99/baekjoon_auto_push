
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int StringLength = Integer.parseInt(br.readLine());
        int count = 0;
        String[] inputStringList = br.readLine().split("");
        String[] wantStringList = makeList(num);
        int wantIndex = 0;

        /*
        하나의 for문 으로 해결이 가능해야 한다. -> 범위가 백만개
        마치 인쇄장에서 찍어내듯이 wantList를 비교할 수 있어야 한다.
        빼내보기
         */

        for (int i = 0; i < StringLength; i++) {
            if (inputStringList[i].equals(wantStringList[wantIndex])) {
                wantIndex++;
            }

            else if (inputStringList[i].equals("I")) {
                wantIndex = 1;
            }

            else {
                wantIndex = 0;
            }

            if (wantIndex == wantStringList.length) {
                /*
                1에서는 1
                2에서는 3
                3에서는 5
                 */
                wantIndex = 2 * (num - 1) + 1;
                count++;
            }
        }

        System.out.println(count);
    }

    private static String[] makeList(int num) {
        String[] wantList = new String[num * 2 + 1];

        for (int i = 0; i < 2 * num + 1; i++) {
            if (i % 2 == 0) {
                wantList[i] = "I";
                continue;
            }
            wantList[i] = "O";
        }

        return wantList;
    }
}