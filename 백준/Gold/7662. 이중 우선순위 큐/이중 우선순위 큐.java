
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        입력 데이터는 표준입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다.
        입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
        각 테스트 데이터의 첫째 줄에는 Q에 적용할 연산의 개수를 나타내는 정수 k (k ≤ 1,000,000)가 주어진다.
        이어지는 k 줄 각각엔 연산을 나타내는 문자(‘D’ 또는 ‘I’)와 정수 n이 주어진다. ‘I n’은 정수 n을 Q에 삽입하는 연산을 의미한다.
        동일한 정수가 삽입될 수 있음을 참고하기 바란다.
        ‘D 1’는 Q에서 최댓값을 삭제하는 연산을 의미하며, ‘D -1’는 Q 에서 최솟값을 삭제하는 연산을 의미
        출력은 표준출력을 사용한다. 각 테스트 데이터에 대해, 모든 연산을 처리한 후 Q에 남아 있는 값 중 최댓값과 최솟값을 출력하라.
        두 값은 한 줄에 출력하되 하나의 공백으로 구분하라. 만약 Q가 비어있다면 ‘EMPTY’를 출력하라.
         */
        int testcaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcaseNum; i++) {
            HashMap<Integer, Integer> howManyLeft = new HashMap<>();
            int calNum = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());
            int Dnum = 0;
            int Inum = 0;
            for (int j = 0; j < calNum; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String dOrI = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (dOrI.equals("I")) {
                    pq.add(num);
                    reversePq.add(num);
                    howManyLeft.put(num, howManyLeft.getOrDefault(num, 0) + 1);
                    Inum++;
                }
                if (dOrI.equals("D")) {
                    Dnum++;
                    if (num == -1) {
                        while (!pq.isEmpty()) {
                            int current = pq.peek();
                            if (howManyLeft.get(current) > 0) {
                                pq.poll();
                                howManyLeft.put(current, howManyLeft.get(current) - 1);
                                break;
                            }
                            pq.poll();
                        }
                    }
                    if (num == 1) {
                        while (!reversePq.isEmpty()) {
                            int current = reversePq.peek();
                            if (howManyLeft.get(current) > 0) {
                                reversePq.poll();
                                howManyLeft.put(current, howManyLeft.get(current) - 1);
                                break;
                            }
                            reversePq.poll();
                        }
                    }
                }
            }
            boolean isEmpty = true;
            for (int count : howManyLeft.values()) {
                if (count > 0) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                System.out.println("EMPTY");
                continue;
            }
            int minNum = 0;
            int maxNum = 0;
            while (pq.size() != 0) {
                int current = pq.peek();
                if (howManyLeft.get(current) != 0) {
                    minNum = current;
                    break;
                }
                pq.poll();
            }
            while (reversePq.size() != 0) {
                int current = reversePq.peek();
                if (howManyLeft.get(current) != 0) {
                    maxNum = current;
                    break;
                }
                reversePq.poll();
            }
            System.out.println(maxNum + " " + minNum);
        }
    }
}