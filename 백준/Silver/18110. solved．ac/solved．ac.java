
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfPeople = Integer.parseInt(br.readLine());
        int[] scores = new int[numOfPeople];

        for (int i = 0; i < numOfPeople; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int ignorepeople = (int) Math.round( numOfPeople * 0.15);

        Arrays.sort(scores);

        int addValue = 0;

        for (int i = ignorepeople; i < numOfPeople - ignorepeople; i++) {
            addValue += scores[i];
        }
        System.out.println((int) Math.round((double) addValue / (numOfPeople - 2 * ignorepeople)));
        // System.out.println("addValue = " + addValue);
    }
}
