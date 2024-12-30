
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int StringLength = Integer.parseInt(br.readLine());
        int count = 0;
        String input = br.readLine();
        String wantString = makeList(num);
        /*
        하나의 for문 으로 해결이 가능해야 한다. -> 범위가 백만개
        마치 인쇄장에서 찍어내듯이 wantList를 비교할 수 있어야 한다.
        빼내보기
         */

        for (int i = 0; i < StringLength - 2 * num; i++) {
            String j = input.substring(i, i + 2 * num + 1);
            if (j.equals(wantString))
                count++;
        }

        System.out.println(count);
    }

    private static String makeList(int num) {
        String wantList = "";

        for (int i = 0; i < 2 * num + 1; i++) {
            if (i % 2 == 0) {
                wantList += "I";
                continue;
            }
            wantList += "O";
        }

        return wantList;
    }
}