import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int calNum = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < calNum; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0)
                list.add(input);
            else {
                if (list.size() != 0)
                    System.out.println(list.poll());
                else {
                    System.out.println(0);
                }
            }
        }
    }
}