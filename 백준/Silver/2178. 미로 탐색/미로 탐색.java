
import java.io.*;
import java.util.*;

public class Main {
    static int[][] miro;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int column = input[0];
        int row = input[1];
        miro = new int[column][row];
        for (int i = 0; i < column; i++) {
            int[] currentColumn = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < row; j++) {
                miro[i][j] = currentColumn[j];
            }
        }

        int depthResult = bfs();
        System.out.println(depthResult);
    }

    private static int bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        // 2차원 배열을 사용하여 방문 및 깊이 저장
        int[][] depth = new int[miro.length][miro[0].length];
        boolean[][] visited = new boolean[miro.length][miro[0].length];

        visited[0][0] = true;
        depth[0][0] = 1;  // 시작점도 카운트에 포함

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < miro.length && nx >= 0 && nx < miro[0].length
                        && miro[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    depth[ny][nx] = depth[y][x] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        return depth[miro.length-1][miro[0].length-1];
    }
}