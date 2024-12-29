
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int currentLocation = input[0];
        int findLocation = input[1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(currentLocation);
        HashMap<Integer, Integer> depth = new HashMap<>();
        depth.put(currentLocation, 0);

        while (queue.size() != 0) {
            int thisLocation= queue.removeFirst();
            int thisDepth = depth.get(thisLocation);
            thisDepth++;

            int[] canGoList = {thisLocation - 1, thisLocation + 1, thisLocation * 2};

            for (int i : canGoList) {
                if (!depth.containsKey(i) && i >= 0 && i <= 100000) {
                    depth.put(i, thisDepth);
                    queue.add(i);
                }
            }

            if (depth.containsKey(findLocation))
                break;
        }

        System.out.println(depth.get(findLocation));
    }
}