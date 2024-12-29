
import java.io.*;
import java.util.*;

public class Main {
    static int[][] apartment;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> apartmentNum = new ArrayList<>();
        int index = Integer.parseInt(br.readLine());
        apartment = new int[index][index];
        for (int i = 0; i < index; i++) {
            int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < index; j++) {
                apartment[i][j] = input[j];
            }
        }

        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                if (apartment[i][j] == 1)
                    apartmentNum.add(bfs(i, j));
            }
        }

        Collections.sort(apartmentNum);
        System.out.println(apartmentNum.size());

        for (int i : apartmentNum) {
            System.out.println(i);
        }
    }

    private static int bfs(int startCol, int startRow) {
        int apartmentNum = 0;
        Deque<int[]> ternal = new ArrayDeque<>();
        ternal.add(new int[] {startCol, startRow});
        apartmentNum++;
        apartment[startCol][startRow] = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (ternal.size() != 0) {
            int[] thisNode = ternal.removeFirst();
            int thisCol = thisNode[0];
            int thisRow = thisNode[1];

            for (int i = 0; i < 4; i++) {
                if (thisCol + dy[i] >= 0 && thisCol + dy[i] < apartment.length && thisRow + dx[i] >= 0 && thisRow + dx[i] < apartment[0].length
                        && apartment[thisCol + dy[i]][thisRow + dx[i]] == 1) {
                    ternal.add(new int[] {thisCol + dy[i], thisRow + dx[i]});
                    apartment[thisCol + dy[i]][thisRow + dx[i]] = 0;
                    apartmentNum++;
                }
            }
        }

        return apartmentNum;
    }
}