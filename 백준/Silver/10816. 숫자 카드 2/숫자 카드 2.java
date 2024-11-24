
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> hashMap = new HashMap<>();

        int howManyHave = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < cards.length; i++) {
            Integer getInt = hashMap.get(Integer.valueOf(cards[i]));
            if (getInt == null) {
                hashMap.put(cards[i], 1);
            }
            else {
                hashMap.put(cards[i], getInt + 1);
            }
        }

        int howManySolve = Integer.parseInt(br.readLine());
        int[] solveCards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < solveCards.length; i++) {
            Integer getInt = hashMap.get(solveCards[i]);
            if (getInt == null)
                bw.write(0 + " ");
            else
                bw.write(getInt + " ");
        }
        bw.close();
    }
}
