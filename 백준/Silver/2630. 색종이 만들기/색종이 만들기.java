
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] totalPaper;
    static int[] whiteAndBlue = new int[2];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperLength = Integer.parseInt(br.readLine());
        totalPaper = new int[paperLength][paperLength];

        for (int i = 0; i < paperLength; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < paperLength; j++) {
                totalPaper[i][j] = input[j];
            }
        }

        int startX = 0;
        int startY = 0;

        slicePaper(startX, startY, paperLength);
        for (int i: whiteAndBlue) {
            System.out.println(i);
        }
    }

    private static void slicePaper(int startX, int startY, int totalLength) {

        if (totalLength == 1) {
            if (totalPaper[startX][startY] == 1)
                whiteAndBlue[1]++;
            else
                whiteAndBlue[0]++;
            return;
        }

        for (int i = startX; i < startX + totalLength; i++) {
            for (int j = startY; j < startY + totalLength; j++) {
                if (totalPaper[startX][startY] != totalPaper[i][j]) {
                    slicePaper(startX, startY, totalLength / 2);
                    slicePaper(startX + (totalLength / 2), startY, totalLength / 2);
                    slicePaper(startX + (totalLength / 2), startY + (totalLength / 2), totalLength / 2);
                    slicePaper(startX, startY + (totalLength / 2), totalLength / 2);
                    return;
                }
            }
        }

        if (totalPaper[startX][startY] == 1)
            whiteAndBlue[1]++;
        else
            whiteAndBlue[0]++;
    }
}