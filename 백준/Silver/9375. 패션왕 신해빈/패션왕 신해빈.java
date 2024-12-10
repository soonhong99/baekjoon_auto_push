
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNum; i++) {
            int clothesNum = Integer.parseInt(br.readLine());
            System.out.println(makeFassion(clothesNum, br));
        }
    }

    private static int makeFassion(int clothesNum, BufferedReader br) throws Exception{
        HashMap<String, Integer> clothes = new HashMap<>();
        final int[] totalNum = {1};

        for (int i = 0; i < clothesNum; i++) {
            String[] clothNameAndType = br.readLine().split(" ");
            if (clothes.containsKey(clothNameAndType[1])) {
                int currentNum = clothes.get(clothNameAndType[1]);
                clothes.put(clothNameAndType[1], currentNum + 1);
            }
            else {
                clothes.put(clothNameAndType[1], 1);
            }
        }

        clothes.forEach((key, value) -> totalNum[0] *= value + 1);

        /*
        2가지 종류 -> 1가지만 선택할 때, 2가지 모두 선택할 때
        3가지 종류 -> 1가지만 선택할 때, 2가지 모두 선택할 때, 3가지 모두 선택할 때
         */

        return totalNum[0] - 1;
    }
}