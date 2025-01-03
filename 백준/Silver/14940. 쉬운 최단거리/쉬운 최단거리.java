
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static int[][] land;
    static int[][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxColumn = input[0];
        int maxRow = input[1];
        int startColumn = 0;
        int startRow = 0;

        land = new int[maxColumn][maxRow];
        distance = new int[maxColumn][maxRow];
        for (int i = 0; i < maxColumn; i++) {
            int[] currentRow = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < maxRow; j++) {
                land[i][j] = currentRow[j];
                distance[i][j] = -1;
                if (currentRow[j] == 2) {
                    startColumn = i;
                    startRow = j;
                    distance[i][j] = 0;
                }
                if (currentRow[j] == 0) {
                    distance[i][j] = 0;
                }
            }
        }
        /*
        일단 도달하지 못한 곳을 거리 -1 이라고 설정. 왜? -> 갈 수 있는 땅인지, 아닌지 알 수 없으므로.
         */
        bfs(startColumn, startRow);
        for (int i = 0; i < land.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < land[0].length; j++) {
                sb.append(distance[i][j] + " ");
            }
            System.out.println(sb);
        }
    }

    private static void bfs(int startColumn, int startRow) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        Deque<int[]> ternal = new ArrayDeque<>();
        ternal.add(new int[] {startColumn, startRow});

        while (ternal.size() != 0) {
            int[] currentNode = ternal.poll();
            for (int i = 0; i < 4; i++) {
                int moveColumn = currentNode[0] + dy[i];
                int moveRow = currentNode[1] + dx[i];
                if (moveColumn >= 0 && moveColumn < land.length && moveRow >= 0 && moveRow < land[0].length
                        && land[moveColumn][moveRow] == 1 && distance[moveColumn][moveRow] == -1) {
                    distance[moveColumn][moveRow] = distance[currentNode[0]][currentNode[1]] + 1;
                    ternal.add(new int[] {moveColumn, moveRow});
                }
            }
        }
    }
}