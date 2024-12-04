
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
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        Map<String, String> siteInfo = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] inputSiteInfo = br.readLine().split(" ");
            siteInfo.put(inputSiteInfo[0], inputSiteInfo[1]);
        }
        for (int i = 0; i < M; i++) {
            System.out.println(siteInfo.get(br.readLine()));
        }
    }
}
