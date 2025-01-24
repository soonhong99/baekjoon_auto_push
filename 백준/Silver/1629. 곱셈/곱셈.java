
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int dividerNum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        dividerNum = Integer.parseInt(st.nextToken());

        System.out.println(divideQuanquer(A, B));
    }

    private static long divideQuanquer(int A, int B) {
        if (B == 1)
            return A % dividerNum;
        long temp = divideQuanquer(A, B / 2); // 안에서 어떻게 결과값을 갖고, 다시 올라가고, 거기서 또 결과값을 갖고 올라가고 ... 약간
        if (B % 2 == 1) // 제곱이 홀수인 경우에는 한번더 곱해야 하므로 temp에 A를 곱한다.
            return (((temp * temp) % dividerNum) * (A % dividerNum)) % dividerNum;
        return ((temp % dividerNum) * (temp % dividerNum)) % dividerNum;
    }
}