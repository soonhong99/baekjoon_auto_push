
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numOfInput = Integer.parseInt(br.readLine());
        int[] set = new int[20];
        for (int i = 0; i < numOfInput; i++) {
            String[] input = br.readLine().split(" ");
            int x = 0;
            String howToMakeInput = input[0];
            if (input.length == 2)
                x = Integer.parseInt(input[1]);
            if (howToMakeInput.equals("add")) {
                set[x - 1] = 1;
            }
            else if (howToMakeInput.equals("check")) {
                bw.write(set[x - 1] + "\n");
            }
            else if (howToMakeInput.equals("remove")) {
                set[x - 1] = 0;
            }
            else if (howToMakeInput.equals("toggle")) {
                if (set[x - 1] == 0)
                    set[x - 1] = 1;
                else
                    set[x - 1] = 0;
            }
            else if (howToMakeInput.equals("all")) {
                for (int j = 0; j < 20; j++)
                    set[j] = 1;
            }
            else if (howToMakeInput.equals("empty")) {
                set = new int[20];
            }
            
        }
        bw.flush();
    }
}
