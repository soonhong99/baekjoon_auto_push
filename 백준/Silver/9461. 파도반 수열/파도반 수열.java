
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNum; i++) {
            int wonderingTriangleSize = Integer.parseInt(br.readLine());
            System.out.println(calculateTriangleSize(wonderingTriangleSize));
        }
    }

    private static long calculateTriangleSize(int wonderingTriSize) {
        // 1, 1, 1, 2, 2, (1 + 2)3, (1 + 3)4, (1 + 4)5, (5 + 2)7, (7 + 2)9, (9 + 3)12, (12 + 4)16, (16 + 5)21,

        ArrayList<Long> triangleList = new ArrayList<>(Arrays.asList(1L, 1L, 1L, 2L, 2L, 3L, 4L, 5L, 7L, 9L));

        int addNumIndex = 5;

        if (wonderingTriSize <= 10)
            return triangleList.get(wonderingTriSize - 1);
        else {
            for (int i = 9; i < wonderingTriSize; i++) {
                long beforeTri = triangleList.get(i);
                long addNum = triangleList.get(addNumIndex);
                triangleList.add(beforeTri + addNum);
                addNumIndex++;
            }
        }
        return triangleList.get(wonderingTriSize - 1);
    }
}