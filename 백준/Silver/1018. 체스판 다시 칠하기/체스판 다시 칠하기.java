
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M, N;
        int[] mAndM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        M = mAndM[0];
        N = mAndM[1];

        String[][] chessBoard = makeChessBoard(M, N, br);
        // 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
        // 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
        int minimumPainting = findMinimumPainting(chessBoard, M, N);
        System.out.println(minimumPainting);
    }

    private static String[][] makeChessBoard(int M, int N, BufferedReader br) throws Exception {
        String[][] originChessBoard = new String[M][N];

        for (int i = 0; i < M; i++) {
            String[] chessRow = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                originChessBoard[i][j] = chessRow[j];
            }
        }

        return originChessBoard;
    }

    private static int findMinimumPainting(String[][] chessBoard, int M, int N) {
        int startRow = 0;
        int startColumn = 0;
        int minimumPainting = 999;
        while (true) {
            int currentPaint = 0;
            int reverseCurrentPaint = 0;
            String startColor = chessBoard[startRow][startColumn];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (((i + j) % 2 == 0 && !chessBoard[startRow + i][startColumn + j].equals(startColor)) || ((i + j) % 2 == 1) && chessBoard[startRow + i][startColumn + j].equals(startColor)) {
                        currentPaint++;
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (((i + j) % 2 == 0 && chessBoard[startRow + i][startColumn + j].equals(startColor)) || ((i + j) % 2 == 1) && !chessBoard[startRow + i][startColumn + j].equals(startColor)) {
                        reverseCurrentPaint++;
                    }
                }
            }
            if (reverseCurrentPaint < currentPaint) {
                currentPaint = reverseCurrentPaint;
            }
            if (currentPaint < minimumPainting) {
                minimumPainting = currentPaint;
            }
            if (startRow + 8 < M) {
                startRow++;
            }
            else if (startColumn + 8 < N) {
                startRow = 0;
                startColumn++;
            }
            else {
                break;
            }
        }
        return minimumPainting;
    }
}
