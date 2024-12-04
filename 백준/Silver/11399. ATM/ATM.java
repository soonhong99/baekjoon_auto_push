
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int peopleNum = Integer.parseInt(br.readLine());
        int[] timeToGet = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int totalTime = 0;
        for (int i = 0; i < peopleNum; i++) {
            for (int j = 0; j <= i; j++) {
                totalTime += timeToGet[j];
            }
        }
        System.out.println(totalTime);
    }
}
