
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
        int dd = input[0];
        int bb = input[1];
        Set<String> ddSet = new HashSet<>();
        Set<String> bbSet = new HashSet<>();
        for (int i = 0; i < dd; i++) {
            ddSet.add(br.readLine());
        }
        for (int i = 0; i < bb; i++) {
            bbSet.add(br.readLine());
        }
        ddSet.retainAll(bbSet);
        System.out.println(ddSet.size());
        Object[] ddList =  ddSet.toArray();
        Object[] ddListSorted =  Arrays.stream(ddList).sorted().toArray();
        for (Object i : ddListSorted) {
            bw.write(i + "\n");
        }
        bw.flush();
    }
}
