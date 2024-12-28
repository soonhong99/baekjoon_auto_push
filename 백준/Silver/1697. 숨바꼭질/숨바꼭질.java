import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int start = input[0];
        int target = input[1];
        
        System.out.println(findMinimumTime(start, target));
    }
    
    private static int findMinimumTime(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();  // 위치, 시간
        
        queue.offer(start);
        visited.put(start, 0);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int time = visited.get(current);
            
            if (current == target) {
                return time;
            }
            
            // 가능한 다음 위치들
            int[] next = {current - 1, current + 1, current * 2};
            
            for (int nextPos : next) {
                if (nextPos >= 0 && nextPos <= 100000 && !visited.containsKey(nextPos)) {
                    queue.offer(nextPos);
                    visited.put(nextPos, time + 1);
                }
            }
        }
        
        return -1;
    }
}