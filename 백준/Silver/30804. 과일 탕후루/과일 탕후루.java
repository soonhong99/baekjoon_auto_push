import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] fruits = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        
        // 과일 종류 카운트를 위한 배열
        int[] fruitCount = new int[10];  // 1~9까지의 과일
        int distinctTypes = 0;  // 현재 구간에 있는 서로 다른 과일의 종류 수
        int maxLength = 1;     // 가능한 최대 길이 (최소 1개는 항상 가능)
        
        // 투 포인터 적용
        int left = 0;
        
        for (int right = 0; right < N; right++) {
            // 새로운 과일 추가
            if (fruitCount[fruits[right]]++ == 0) {
                distinctTypes++;
            }
            
            // 과일 종류가 3개 이상이면 left 포인터 이동
            while (distinctTypes > 2) {
                if (--fruitCount[fruits[left]] == 0) {
                    distinctTypes--;
                }
                left++;
            }
            
            // 현재 구간의 길이로 최대 길이 갱신
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        System.out.println(maxLength);
    }
}