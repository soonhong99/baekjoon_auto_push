
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[] depth = new int[101];
    static HashMap<Integer, Integer> stairMap = new HashMap<>();
    static HashMap<Integer, Integer> snakeMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int stair = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());
        stairMap = new HashMap<>();
        snakeMap = new HashMap<>();
        for (int i = 0; i < stair; i++) {
            StringTokenizer stairST = new StringTokenizer(br.readLine());
            stairMap.put(Integer.parseInt(stairST.nextToken()), Integer.parseInt(stairST.nextToken()));
        }
        for (int i = 0; i < snake; i++) {
            StringTokenizer snakeST = new StringTokenizer(br.readLine());
            snakeMap.put(Integer.parseInt(snakeST.nextToken()), Integer.parseInt(snakeST.nextToken()));
        }

        /*
        1에서부터 100까지 도착하려면 어떻게 주사위를 최소로 던질 수 있을까?
        한 숫자에서 1 ~ 6까지만 증가 가능
        뱀이 관건인데, 있는 이유가 있을거같아. 뱀이랑 사다리 수가 많지 않고, 100으로 정해놨어. 이러면은 뭐.. 어느정도 for문을 돌려도 상관없을듯
        depth를 어떻게 표현하고, 갔다온 곳은 그럼 이제 다시는 못가게 해야되는건가?
        1을 depth 0이라고 하고,  1 ~ 6 중 갈 수 있는 곳을 그다음 depth로 설정하고,
        그다음에 뱀이나 사다리 숫자에 위치하면 그곳으로 옮겨져서 다시 depth 설정하고..
        */

        bfs();
        System.out.println(depth[100]);
    }

    private static void bfs() {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        while (queue.size() != 0) {
            int currentLocation = queue.removeFirst();
            int momDepth = depth[currentLocation];
            for (int i = 1; i <= 6; i++) {
                if (currentLocation + i > 100)
                    continue;
                if (depth[currentLocation + i] == 0) {
                    depth[currentLocation + i] = momDepth + 1;
                    if (stairMap.containsKey(currentLocation + i)) {
                        if (depth[stairMap.get(currentLocation + i)] > momDepth + 1 || depth[stairMap.get(currentLocation + i)] == 0)
                            depth[stairMap.get(currentLocation + i)] = momDepth + 1;
                        queue.add(stairMap.get(currentLocation + i));
                        continue;
                    }
                    else if (snakeMap.containsKey(currentLocation + i)) {
                        if (depth[snakeMap.get(currentLocation + i)] > momDepth + 1 || depth[snakeMap.get(currentLocation + i)] == 0)
                            depth[snakeMap.get(currentLocation + i)] = momDepth + 1;
                        queue.add(snakeMap.get(currentLocation + i));
                        continue;
                    }
                    queue.add(currentLocation + i);
                }
            }
        }
    }
}