
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rotateNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < rotateNum; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int numOfDoc = input[0];
            int printOrder = 0;
            int currentLocationOfDocWonderedWhenPrint = input[1];
            int[] inputDoc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Deque<Integer> inputDeque = new ArrayDeque<>();

            for (int j = 0; j < inputDoc.length; j++) {
                inputDeque.add(inputDoc[j]);
            }

            while (true) {
                // Integer::Compare의 의미
                int max = inputDeque.stream().max(Integer::compare).orElseThrow();
                Integer firstElement = inputDeque.getFirst();
                if (firstElement < max) {
                    inputDeque.removeFirst();
                    inputDeque.addLast(firstElement);
                }
                else {
                    printOrder++;
                    if (currentLocationOfDocWonderedWhenPrint == 0) {
                        System.out.println(printOrder);
                        break;
                    }
                    inputDeque.removeFirst();
                }
                if (currentLocationOfDocWonderedWhenPrint != 0) {
                    currentLocationOfDocWonderedWhenPrint--;
                }
                else {
                    currentLocationOfDocWonderedWhenPrint = inputDeque.size() - 1;
                }
            }
        }
    }
}
