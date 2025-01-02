
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int[][] land;
    static int[][] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] lineNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startX = 0;
        int startY = 0;
        land = new int[lineNum[0]][lineNum[1]];
        depth = new int[land.length][land[0].length];
        for (int i = 0; i < lineNum[0]; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < lineNum[1]; j++) {
                if (input[j] == 2) {
                    startX = i;
                    startY = j;
                    continue;
                }
                land[i][j] = input[j];
                if (input[j] == 1)
                    depth[i][j] = -1;
            }
        }

        calDistance(startX, startY);

        for (int i = 0; i < lineNum[0]; i++) {
            StringBuilder currentRow = new StringBuilder();
            for (int j = 0; j < lineNum[1]; j++) {
                currentRow.append(depth[i][j] + " ");
            }
            System.out.println(currentRow);
        }
    }

    private static void calDistance(int startX, int startY) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {startX, startY});
        depth[startX][startY] = 0;

        while (deque.size() != 0) {
            int[] currentNode = deque.poll();
            int distance = depth[currentNode[0]][currentNode[1]];
            for (int i = 0; i < 4; i++) {
                int nx = currentNode[0] + dx[i];
                int ny = currentNode[1] + dy[i];
                if (nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length) {
                    if (land[nx][ny] == 1 && depth[nx][ny] == -1) {
                        deque.add(new int[] {nx, ny});
                        land[nx][ny] = 0;
                        depth[nx][ny] = distance + 1;
                    }
//                    else if (land[nx][ny] == 0)
//                        depth[nx][ny] = 0;
                }
            }
        }
    }
}