import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    
    int[] minList = new int[x + 1];
    
    // Bottom-up DP
    for(int i = 2; i <= x; i++) {
        minList[i] = minList[i-1] + 1;  // 1을 빼는 경우
        
        if(i % 2 == 0)
            minList[i] = Math.min(minList[i], minList[i/2] + 1);
            
        if(i % 3 == 0)
            minList[i] = Math.min(minList[i], minList[i/3] + 1);
    }
    
    System.out.println(minList[x]);
    }
}

