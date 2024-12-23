
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.spi.AbstractResourceBundleProvider;

public class Main {
    static String[][] campusInfo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] boxLength = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int column = boxLength[0];
        int row = boxLength[1];
        campusInfo = new String[column][row];
        int doCol = 0;
        int doRow = 0;

        for (int i = 0; i < column; i++) {
            String[] currentColumnInfo = br.readLine().split("");
            for (int j = 0; j < row; j++) {
                campusInfo[i][j] = currentColumnInfo[j];
                if (campusInfo[i][j].equals("I")) {
                    doCol = i;
                    doRow = j;
                }
            }
        }
        int meetPeopleNum = bfs(doCol, doRow);
        if (meetPeopleNum == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(meetPeopleNum);
    }

    private static int bfs(int doCol, int doRow) {
        int meetPeopleNum = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{doCol, doRow});

        while (queue.size() != 0) {
            int[] input = queue.removeFirst();

            for (int i = 0; i < 4; i++) {
                int ny = input[0] + dy[i];
                int nx = input[1] + dx[i];

                if ((ny >= 0 && ny < campusInfo.length) && (nx >= 0 && nx < campusInfo[0].length) 
                        && (campusInfo[ny][nx].equals("O") || campusInfo[ny][nx].equals("P"))) {
                    if (campusInfo[ny][nx].equals("P"))
                        meetPeopleNum++;
                    campusInfo[ny][nx] = "X";
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        return meetPeopleNum;
    }


}