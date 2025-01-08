
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import javax.swing.JInternalFrame;

public class Main {
    static String[][] paper;
    static String[][] rgPaper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        paper = new String[length][length];
        rgPaper = new String[length][length];
        for (int i = 0; i < length; i++) {
            String[] currentPaper = br.readLine().split("");
            for (int j = 0; j < length; j++) {
                paper[i][j] = currentPaper[j];
                rgPaper[i][j] = currentPaper[j];
            }
        }
        int count = 0;
        int rgCount = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!paper[i][j].equals("A")) {
                    bfs(i, j);
                     count++;
                }
                if (!rgPaper[i][j].equals("A")) {
                    rgBfs(i, j);
                    rgCount++;
                }
            }
        }
        System.out.println(count + " " + rgCount);
    }

    static void bfs(int startColumn, int startRow) {
        // R, G, B 모두 다른 색으로 판별
        String startColor = paper[startColumn][startRow];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startColumn, startRow});
        paper[startColumn][startRow] = "A";

        while (queue.size() != 0) {
            int[] thisLocation = queue.poll();
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nx = thisLocation[0] + dx[i];
                int ny = thisLocation[1] + dy[i];
                if (nx >= 0 && nx < paper.length && ny >= 0 && ny < paper.length
                        && paper[nx][ny].equals(startColor)) {
                    paper[nx][ny] = "A";
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }

    static void rgBfs(int startColumn, int startRow) {
        // R, G를 같은 색으로 판별, B만 다른색깔
        String startColor = rgPaper[startColumn][startRow];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startColumn, startRow});
        rgPaper[startColumn][startRow] = "A";
        boolean canCorrect = false;
        if (startColor.equals("R") || startColor.equals("G"))
            canCorrect = true;

        while (queue.size() != 0) {
            int[] thisLocation = queue.poll();
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nx = thisLocation[0] + dx[i];
                int ny = thisLocation[1] + dy[i];
                if (nx >= 0 && nx < rgPaper.length && ny >= 0 && ny < rgPaper.length) {
                    if (canCorrect && (rgPaper[nx][ny].equals("G") || rgPaper[nx][ny].equals("R"))) {
                        rgPaper[nx][ny] = "A";
                        queue.add(new int[] {nx, ny});
                    }

                    else if (rgPaper[nx][ny].equals(startColor)) {
                        rgPaper[nx][ny] = "A";
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}