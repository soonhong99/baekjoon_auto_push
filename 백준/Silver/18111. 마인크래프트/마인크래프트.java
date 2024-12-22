
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] groundHeightList;
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int column = input[0];
        int row = input[1];
        int blockNum = input[2];
        groundHeightList = new int[column][row];
        for (int i = 0; i < column; i++) {
            int[] inputGroundHeight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < row; j++) {
                int currentNum = inputGroundHeight[j];
                if (currentNum > maxNum)
                    maxNum = currentNum;
                if (currentNum < minNum)
                    minNum = currentNum;
                groundHeightList[i][j] = currentNum;
            }
        }

        int[] result = makeFlat(blockNum);
        System.out.print(result[0] + " " + result[1]);
    }

    private static int[] makeFlat(int blockNum) {
        int[] result = new int[2];
        int timeToMakeFlat = Integer.MAX_VALUE;
        int groundHeight = 0;
        int currentTargetHeight = minNum;
        int needBlock = 0;

        while (currentTargetHeight != maxNum + 1) {
            int currentBlockNum = blockNum;
            int currentTimeToMakeFlat = 0;
            for (int i = 0; i < groundHeightList.length; i++) {
                for (int j = 0; j < groundHeightList[i].length; j++) {
                    int thisGroundHeight = groundHeightList[i][j];
                    // 이 땅이 타겟 높이보다 높을 시, 도려내야지
                    if (thisGroundHeight > currentTargetHeight) {
                        currentBlockNum += (thisGroundHeight - currentTargetHeight);
                        currentTimeToMakeFlat += (thisGroundHeight - currentTargetHeight) * 2;
                    }
                    else {
                        currentBlockNum -= (currentTargetHeight - thisGroundHeight);
                        currentTimeToMakeFlat += (currentTargetHeight - thisGroundHeight);
                    }
                }
            }

            if (currentBlockNum < 0) {
                currentTargetHeight++;
                continue;
            }


            if (timeToMakeFlat >= currentTimeToMakeFlat) {
                timeToMakeFlat = currentTimeToMakeFlat;
                groundHeight = currentTargetHeight;
            }

            currentTargetHeight++;
        }


        
        result[0] = timeToMakeFlat;
        result[1] = groundHeight;
        return result;
    }
}