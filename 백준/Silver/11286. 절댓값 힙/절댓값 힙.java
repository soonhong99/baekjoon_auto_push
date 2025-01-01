
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> deque = new PriorityQueue<>();
        HashMap<Integer, Integer> plusMap = new HashMap<>();
        HashMap<Integer, Integer> minusMap = new HashMap<>();
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        /*
        배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
        절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거
        연산의 개수 N(1≤N≤100,000)
        절대값도 갖고있어야 되고, 진짜 숫자도 갖고있어야돼..
        결국에는 두개를 갖고있거나 한개를 갖고있다는 거잖아 -> 음수 많이 갖고 있다 , 양수를 갖고 있다, 두개 다 갖고있다 이렇게 총 세가지
         */
//        for (int i = 0; i < cycle; i++) {
//            int num = Integer.parseInt(br.readLine());
//            int absNum = Math.abs(num);
//            if (num != 0) {
//                if (!deque.contains(absNum)) {
//                    deque.add(absNum);
//                }
//
//                if (num > 0) {
//                    if (!plusMap.containsKey(num))
//                        plusMap.put(num, 1);
//                    else
//                        plusMap.put(num, plusMap.get(num) + 1);
//                }
//                if (num < 0) {
//                    if (!minusMap.containsKey(num))
//                        minusMap.put(num, 1);
//                    else
//                        minusMap.put(num, minusMap.get(num) + 1);
//                }
//
//                continue;
//            }
//            if (deque.size() == 0) {
//                System.out.println(0);
//                continue;
//            }
//            int getNum = deque.poll();
//            if (minusMap.getOrDefault(-getNum, 0) != 0) {
//                System.out.println(-getNum);
//                minusMap.put(-getNum, minusMap.get(-getNum) - 1);
//            }
//            else if (plusMap.getOrDefault(getNum, 0) != 0) {
//                System.out.println(getNum);
//                plusMap.put(getNum, plusMap.get(getNum) - 1);
//            }
//            if (plusMap.getOrDefault(getNum, 0) != 0 || minusMap.getOrDefault(-getNum, 0) != 0)
//                deque.add(getNum);
//        }
        for (int i = 0; i < cycle; i++) {
            int num = Integer.parseInt(br.readLine());
            int absNum = Math.abs(num);
            if (num != 0) {
                if (num != absNum)
                    minusQueue.add(absNum);
                else
                    deque.add(num);
            }
            else {
                if (minusQueue.isEmpty() && deque.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                else if (deque.isEmpty() && !minusQueue.isEmpty()) {
                    System.out.println(minusQueue.poll() * -1);
                    continue;
                }
                else if (minusQueue.isEmpty() && !deque.isEmpty()) {
                    System.out.println(deque.poll());
                    continue;
                }
                int currentMinus = minusQueue.poll();
                int currentPlus = deque.poll();
                if (currentPlus == currentMinus) {
                    System.out.println(-1 * currentPlus);
                    deque.add(currentPlus);
                }
                else if (currentPlus > currentMinus) {
                    System.out.println(currentMinus * -1);
                    deque.add(currentPlus);
                }
                else if (currentPlus < currentMinus) {
                    System.out.println(currentPlus);
                    minusQueue.add(currentMinus);
                }
            }
        }
    }
}