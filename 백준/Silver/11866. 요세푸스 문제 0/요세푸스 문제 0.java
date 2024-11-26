
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPeople;
        int killOrder;

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        numberOfPeople = input[0];
        killOrder = input[1];

        ArrayList<Integer> deadPeople = new ArrayList<>();

        int deadNum = 0;
        // 1, 2, 3, 4, 5, 6, 7 -> 3, 6, 2, 7, 5, 1, 4
        for (int i = 0; i < numberOfPeople; i++) {
            for (int j = 0; j < killOrder; j++) {
                deadNum++;
                while (true) {
                    if (deadPeople.contains(deadNum) && deadNum != numberOfPeople)
                        deadNum++;
                    else if (deadPeople.contains(deadNum) && deadNum == numberOfPeople)
                        deadNum = 1;
                    else
                        break;
                }
                if (deadNum == numberOfPeople)
                    deadNum = 0;
            }
            if (deadNum == 0)
                deadPeople.add(numberOfPeople);
            else
                deadPeople.add(deadNum);
        }
        System.out.print("<");
        int count = 1;
        deadPeople.forEach(i -> {
            if (i != deadPeople.get(deadPeople.size() - 1)) {
                System.out.print(i + ", ");
            } else {
                System.out.print(i);
            }
        });
        System.out.print(">");
    }
}
