
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNum; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int rowLength = input[0];
            int columnLength = input[1];
            int bachooNum = input[2];
            System.out.println(makeSnail(rowLength, columnLength, bachooNum, br));
        }
    }

    private static int makeSnail(int rowLength, int columnLength, int bachooNum, BufferedReader br) throws Exception{
        int totalSnailNum = 0;
        int[][] ground = new int[rowLength][columnLength];

        for (int i = 0; i < bachooNum; i++) {
            int[] input =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ground[input[0]][input[1]] = 1;
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (ground[i][j] == 1) {
                    ground = bfs(ground, i, j, rowLength, columnLength);
                    totalSnailNum++;
                }
            }
        }

        return totalSnailNum;
    }

    private static int[][] bfs(int[][] ground, int startX, int startY, int rowLength, int colLength) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});

        while (queue.size() != 0) {
            int[] input = queue.removeFirst();

            for (int i = 0; i < 4; i++) {
                int nx = input[0] + dx[i];
                int ny = input[1] + dy[i];

                if ((nx >= 0 && nx < rowLength) && (ny >= 0 && ny < colLength) && ground[nx][ny] == 1) {
                    ground[nx][ny] = 0;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return ground;
    }

}