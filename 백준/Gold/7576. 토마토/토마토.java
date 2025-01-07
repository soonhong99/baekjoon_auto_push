
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] box;
    static int[][] depth;
    static Deque<int[]> overcooked;
    static int totalTomato;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        box = new int[column][row];
        depth = new int[column][row];
        overcooked = new ArrayDeque<>();
        for (int i = 0; i < column; i++) {
            StringTokenizer currentRow = new StringTokenizer(br.readLine());

            for (int j = 0; j < row; j++) {
                int tomatoStatus = Integer.parseInt(currentRow.nextToken());
                box[i][j] = tomatoStatus;
                if (tomatoStatus == -1)
                    continue;
                if (tomatoStatus == 1)
                    overcooked.add(new int[] {i, j});
                totalTomato++;
            }
        }
        /*
        보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
        며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성
        정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
        저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력
        익은 토마토 모든 곳에서 하루를 시작해야되나? 1이 여러개일 수도 있잖아
         */
        int result = bfs();
        System.out.println(result);
    }
    private static int bfs() {
        int maxDepth = Integer.MIN_VALUE;
        int overCookedTomatoNum = 0;

        while (overcooked.size() != 0) {
            int[] currentNode = overcooked.poll();
            overCookedTomatoNum++;
            int momDepth = depth[currentNode[0]][currentNode[1]];
            if (momDepth > maxDepth)
                maxDepth = momDepth;
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nx = currentNode[0] + dx[i];
                int ny = currentNode[1] + dy[i];
                if (nx >= 0 && nx < box.length && ny >= 0 && ny < box[0].length
                        && box[nx][ny] == 0) {
                    box[nx][ny] = -1;
                    overcooked.add(new int[] {nx, ny});
                    // depth 설정
                    depth[nx][ny] = momDepth + 1;
                }
            }
        }

        if (overCookedTomatoNum != totalTomato)
            return -1;

        return maxDepth;
    }
}