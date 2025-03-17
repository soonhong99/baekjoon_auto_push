

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        체스는 총 16개의 피스를 사용하며, 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개로 구성
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int king = Integer.parseInt(st.nextToken());
        int queen = Integer.parseInt(st.nextToken());
        int look = Integer.parseInt(st.nextToken());
        int shop = Integer.parseInt(st.nextToken());
        int knight = Integer.parseInt(st.nextToken());
        int pone = Integer.parseInt(st.nextToken());

        king = 1 - king;
        queen = 1 - queen;
        look = 2 - look;
        shop = 2 - shop;
        knight = 2 - knight;
        pone = 8 - pone;

        System.out.println(king + " " + queen + " " + look + " " + shop + " " + knight + " " + pone);
    }
}