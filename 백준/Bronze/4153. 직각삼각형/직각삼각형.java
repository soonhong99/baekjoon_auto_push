import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            int max = Math.max(a, Math.max(b, c));
            if (Math.pow(max, 2) == Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(max, 2)) {
                System.out.println("right");
            } else{
                System.out.println("wrong");
            }
        }
        scanner.close();
    }
}