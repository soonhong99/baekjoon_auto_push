
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import javax.swing.JInternalFrame;

public class Main {
    static int[][][] box;
    static int[][][] depth;
    static int totalTomato = 0;
    static Deque<int[]> overcookedList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
        하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미
        높이를 어떻게 표현하지?
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        box = new int[height][column][row];
        depth = new int[height][column][row];
        overcookedList = new ArrayDeque<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < column; j++) {
                StringTokenizer currentRow = new StringTokenizer(br.readLine());
                for (int k = 0; k < row; k++) {
                    int currentTomato = Integer.parseInt(currentRow.nextToken());
                    box[i][j][k] = currentTomato;
                    if (currentTomato == -1)
                        continue;
                    totalTomato++;
                    if (currentTomato == 1)
                        overcookedList.add(new int[] {i, j, k});
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        int totalOvercooked = 0;
        int maxDepth = Integer.MIN_VALUE;

        while (overcookedList.size() != 0) {
            int[] currentNode = overcookedList.poll();
            int momDepth = depth[currentNode[0]][currentNode[1]][currentNode[2]];
            if (momDepth > maxDepth)
                maxDepth = momDepth;
            int[] dz = {0, 0, 0, 0, -1, 1};
            int[] dy = {0, 0, -1, 1, 0, 0};
            int[] dx = {-1, 1, 0, 0, 0, 0};

            totalOvercooked++;

            for (int i = 0; i < 6; i++) {
                int nz = currentNode[0] + dz[i];
                int ny = currentNode[1] + dy[i];
                int nx = currentNode[2] + dx[i];
                if (nz >= 0 && nz < box.length && ny >= 0 && ny < box[0].length && nx >= 0 && nx < box[0][0].length
                        && box[nz][ny][nx] == 0) {
                    box[nz][ny][nx] = 1;
                    depth[nz][ny][nx] = momDepth + 1;
                    overcookedList.add(new int[] {nz, ny, nx});
                }
            }
        }

        if (totalOvercooked != totalTomato)
            return -1;

        return maxDepth;
    }
}