
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 포켓몬 개수, 맞춰야 하는 개수
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int pokeNum = input[0];
        int haveToSolveProblemNum = input[1];
        Map<Integer, String> hashMap = new HashMap<>();
        Map<String, Integer> reverseHashMap = new HashMap<>();
        for (int i = 0; i < pokeNum; i++) {
            String monster = br.readLine();
            hashMap.put(i + 1, monster);
            reverseHashMap.put(monster, i + 1);
        }

        for (int i = 0; i < haveToSolveProblemNum; i++) {
            int questionNum = -1;
            String questionString = br.readLine();
            boolean isString = false;
            try {
                questionNum = Integer.parseInt(questionString);
            } catch (Exception e) {
                bw.write(reverseHashMap.get(questionString) + "\n");
                isString = true;
            }
            if (!isString) {
                bw.write(hashMap.get(questionNum) + "\n");
            }
        }
        bw.flush();
    }
}
